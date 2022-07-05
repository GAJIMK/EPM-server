package com.dartmedia.dmss.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@ToString
@Getter
@Setter
public class SubmitDay {
  private Date startDay;   
  private Date endDay;
  private int totalDay; 
  
}
