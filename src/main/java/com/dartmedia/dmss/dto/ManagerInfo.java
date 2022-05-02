package com.dartmedia.dmss.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ManagerInfo {
  private short funcId;
  private String funcNm;
  private String managerId;
  private String AccountNm;
  private String ShortNm;
  private String CommonName;
}
