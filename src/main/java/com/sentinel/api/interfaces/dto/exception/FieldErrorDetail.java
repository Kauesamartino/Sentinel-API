package com.sentinel.api.interfaces.dto.exception;

public record FieldErrorDetail(
        String field,
        String message
) {
}
