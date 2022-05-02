package com.dartmedia.dmss.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Manager {
  private short funcId;
  private String managerId;
  private char master;
  private Date expireDate;
  private Date startDate;
  private String email;
}
