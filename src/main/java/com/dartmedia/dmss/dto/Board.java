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
public class Board {
  private int id;
  private Date date;
  private String content;
  private String title;
}
