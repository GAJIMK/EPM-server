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
public class UserFeeState {
  private String accountId;
  private String accountNm;
  private Date date;
  private short state;
  private short acceptLv;
}
