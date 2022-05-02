package com.dartmedia.dmss.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class RequestConfirm {
  private int requestId;
  private String receiverId;
  private String addr;
  private String detailAddr;
  private String msg;
  private String name;
  private int postNo;
  private String phone;
  private Date receiveTime; 
}
