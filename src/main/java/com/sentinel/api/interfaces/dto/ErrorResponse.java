package com.sentinel.api.interfaces.dto;

public class ErrorResponse {

    private int status;
    private String message;
    private String timestamp;
    private String path;

    public ErrorResponse(int status, String message, String timestamp, String path) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }
}
