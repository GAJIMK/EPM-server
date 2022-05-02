package com.dartmedia.dmss.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Mail {
    private String mailFrom;

    private String mailTo;

    private String senderId;

    private String mailSubject;

    private String mailContent;

    private int funcId;

    @Builder
    public Mail(String mailFrom, String mailTo, String senderId, String mailSubject, String mailContent, int funcId) {
        this.mailFrom = mailFrom;
        this.mailTo = mailTo;
        this.senderId = senderId;
        this.mailSubject = mailSubject;
        this.mailContent = mailContent;
        this.funcId = funcId;
    }
}
