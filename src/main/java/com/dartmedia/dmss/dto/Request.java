package com.dartmedia.dmss.dto;

import lombok.*;

import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
public class Request {
  private int requestId;
  private String senderId;
  private String title;
  private String content;
  private String sendTime;

  @Builder
  public Request(String senderId, String title, String content, String sendTime) {
    this.senderId = senderId;
    this.title = title;
    this.content = content;
    this.sendTime = sendTime;
  }
}
