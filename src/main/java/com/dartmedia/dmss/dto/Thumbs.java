package com.dartmedia.dmss.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@ToString
@Getter
@Setter
public class Thumbs {
  private int id; // 게시글의 id
  private String AccountId; // 사용자의 id
}
