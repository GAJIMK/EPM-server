package com.dartmedia.dmss.service;

import com.dartmedia.dmss.core.MailInterface;
import com.dartmedia.dmss.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

// 사용하고자 하는 controller 또는 service에서 기존 repository(service)와 같이 호출하여 사용
// ex) controller: private final MailService mailService

@Slf4j
@Service("mailService")
public class MailService implements MailInterface {

    private final String SENDER = "system@dartmedia.co.kr"; // 관리자 아이디등록
    private final String SENDER_ID = "19971105"; // 관리자 아이디등록
    private final String TEST_SENDER = "dmlwjd558@gmail.com"; // 테스트 본인 이메일 등록

    // 보내고자 하는 메일을 DB Alarm 테이블에 등록후 funcId를 매개변수로 사용해서 메일발송

    @Autowired
    AlarmService alarmService;

    @Autowired
    ManagerService managerService;

    @Autowired
    RequestService requestService;

    @Autowired
    TAccountService tAccountService;

    @Autowired
    JavaMailSender mailSender;


    @Override // 가장 기본적인 sendEmail, 메일발송 후 request에 발송내역 저장
    public void sendEmail(Mail mail) {
        final MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

                helper.setFrom(mail.getMailFrom()); //
                helper.setTo(mail.getMailTo()); //
                helper.setSubject(mail.getMailSubject()); // mail title
                helper.setText(mail.getMailContent(), true); // mail content
            }
        };

        mailSender.send(mimeMessagePreparator);
        // 리퀘스트에 정보 업로드
        addRequestData(mail);

    }

    // 단체 메일을 보낼 때 계정리스트와 보내고자하는 메일유형을 선택하여 발송
    public void sendEMail(List<TAccount> tAccountList, String funcId) {
        for (int i = 0; i < tAccountList.size(); i++) {
            sendEmail(setMail(tAccountList.get(i), funcId));
        }
    }

    // Account 추가 시 메일, 명함, NAS 생성 담당자에게 메일 발송
    public void sendAddAccountMail() {
        Mail[] mailArray = setMailAlarm();
        for (int i = 0; i < mailArray.length; i++) {
            sendEmail(mailArray[i]);
        }
    }

    // Account 추가 시 메일, 명함, NAS 생성 담당자에게 발송할 메일을 설정하는 함수
    private Mail[] setMailAlarm() {
        List<Alarm> alarmList = null;
        List<Manager> managerList = null;

        try {
            alarmList = alarmService.findAddAccountAlarm();
            managerList = managerService.getManagerListWithEmail();
        } catch (Exception e) {
            log.error("Check service/MailService/setMailAlarm!");
        }

        Mail[] mailArray = new Mail[managerList.size()];

        for(int i = 0; i < managerList.size(); i++) {

            Manager manager = managerList.get(i);

            Alarm alarm = null;
            for (int j = 0; j < alarmList.size(); j++) {
                if (manager.getFuncId() == alarmList.get(j).getFuncId()) {
                    alarm = alarmList.get(j);
                }
            }

            Mail mail = Mail.builder()
                    .mailFrom(TEST_SENDER)
                    .mailTo(manager.getEmail())
                    .senderId(SENDER_ID)
                    .mailSubject(alarm.getTitle())
                    .mailContent(alarm.getContent())
                    .funcId(alarm.getFuncId())
                    .build();

            mailArray[i] = mail;
        }

        return mailArray;
    }

    public void sendAppointMail(String funcId) {
        sendEmail(setMail(funcId));
    }

    private Mail setMail(String funcId) {
        Alarm alarm = null;
        String eMail = null;
        int intFuncId = Short.parseShort(funcId);

        try {
            alarm = alarmService.read(funcId);
            List<Manager> managerList = managerService.getManagerListByFuncIdWithEmail(intFuncId);
            for(int i = 0; i < managerList.size(); i++) {
                if( intFuncId == managerList.get(i).getFuncId()) {
                    eMail = managerList.get(i).getEmail();
                }
            }
        } catch (Exception e) {
            log.error("Check service/MailService/setMail!");
        }

        Mail mail = Mail.builder()
                .mailFrom(TEST_SENDER)
                .mailTo(eMail)
                .senderId(SENDER_ID)
                .mailSubject(alarm.getTitle())
                .mailContent(alarm.getContent())
                .funcId(alarm.getFuncId())
                .build();

        return mail;
    }

    // 계정정보와 메일코드를 통한 메일 생성 함수 - sendEmail(List, funcId)에서 사용
    private Mail setMail(TAccount tAccount, String funcId) {
        Alarm alarm = null;

        try {
            alarm = alarmService.read(funcId);
        } catch (Exception e) {
            log.error("Check service/MailService/setMail!");
        }

        Mail mail = Mail.builder()
                .mailFrom(TEST_SENDER)
                .mailTo(tAccount.getEMail())
                .senderId(SENDER_ID)
                .mailSubject(alarm.getTitle())
                .mailContent(alarm.getContent())
                .funcId(alarm.getFuncId())
                .build();

        return mail;
    }

    // Request에 메일 내역을 저장하는 함수
    private void addRequestData(Mail mail) {
        Request request = Request.builder()
                .senderId(mail.getSenderId())
                .title(mail.getMailSubject())
                .content(mail.getMailContent())
                .sendTime(String.valueOf(LocalTime.now()))
                .build();
        try {
            requestService.create(request);
        } catch (Exception e) {
            log.error("Oops!");
        }
    }

}
