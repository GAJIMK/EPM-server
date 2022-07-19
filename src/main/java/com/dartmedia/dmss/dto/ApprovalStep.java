package com.dartmedia.dmss.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class ApprovalStep {
  private String accountId;
  private String accountNm;
  private short teamNo;
  private short upperTeamNo;
}
