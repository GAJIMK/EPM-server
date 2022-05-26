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
  private Date worte_date;
  private String board_content;
  private String board_title;
  private String accountId;
}
