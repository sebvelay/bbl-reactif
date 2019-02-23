package com.svelay.demo.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {

    private String message;
    private Integer index;

}
