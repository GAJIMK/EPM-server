package com.dartmedia.dmss.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Alarm {

    private int funcId;
    private String title;
    private String content;

}
