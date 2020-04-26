package com.javainuse.model;

import lombok.Data;

@Data
public class ResponseMessage {
    private String message;
    private String name;

    public ResponseMessage(String message, String name) {
        this.message = message;
        this.name = name;
    }
}
