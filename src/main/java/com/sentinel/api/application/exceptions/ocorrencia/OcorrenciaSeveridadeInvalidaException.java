package com.sentinel.api.application.exceptions.ocorrencia;

public class OcorrenciaSeveridadeInvalidaException extends RuntimeException {
    public OcorrenciaSeveridadeInvalidaException() {
        super("Severidade da ocorrência não pode ser nula");
    }
}
