package com.dartmedia.dmss.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TAppoint {

    @NotNull(message = "id는 필수 값입니다.")
    private String IDNo;
    private String AccountNm;
    private Date PublishDay;
    private short tpPublish;
    private short TeamNo;
    private short tpPosition;
    private char DirectorYn;
    private char ManagerYn;
    private String AppointMemo;
    private boolean intern;
    private short tpAccount;
}
