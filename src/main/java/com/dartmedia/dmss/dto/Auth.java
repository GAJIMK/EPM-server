package com.dartmedia.dmss.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Auth {
  private String accountId;
  private String accountNm;
  private String password;
  private String token;
  private String role;
}
