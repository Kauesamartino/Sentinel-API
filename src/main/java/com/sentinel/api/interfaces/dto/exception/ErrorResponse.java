package com.sentinel.api.interfaces.dto.exception;

public record ErrorResponse (
        int status,
        String message,
        String timestamp,
        String path){

}

