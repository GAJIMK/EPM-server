package com.dartmedia.dmss.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class UserFeeList {
  private int id;
  private Date date;
  private String content;
  private String place;
  private String companion;
  private String method;
  private String accountId;
  private short part;
  private short state;
  private int price;
}
