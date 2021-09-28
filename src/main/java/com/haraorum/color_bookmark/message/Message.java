package com.haraorum.color_bookmark.message;

import lombok.Builder;
import lombok.Data;

@Data
public class Message {

    private Integer status;
    private String message;
    private Object data;

    public Message() {
        this.status = -1;
        this.data = null;
        this.message = null;
    }

    @Builder
    public Message(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}