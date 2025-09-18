package com.sentinel.api.interfaces.dto.exception;


import java.util.List;

public record ValidationErrorResponse(
        int status,
        String message,
        String timestamp,
        String path,
        List<FieldErrorDetail> fieldErrors
) {
}
