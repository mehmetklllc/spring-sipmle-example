package com.turkishh.ui.model.response;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorMessage {
    private Date timestamp;
    private String message;

    public ErrorMessage(Date timestamp, String message) {
        this.message = message;
        this.timestamp = timestamp;
    }

}