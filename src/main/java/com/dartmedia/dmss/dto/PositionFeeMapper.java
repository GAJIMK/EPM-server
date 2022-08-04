package com.dartmedia.dmss.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionFeeMapper {
  private short positionCode;
  private String positionNm;
  private short feeCode;
  private String feeNm;
  private int fee;
}
