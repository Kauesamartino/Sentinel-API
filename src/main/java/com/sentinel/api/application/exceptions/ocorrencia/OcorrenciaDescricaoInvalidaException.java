package com.sentinel.api.application.exceptions.ocorrencia;

public class OcorrenciaDescricaoInvalidaException extends RuntimeException {
    public OcorrenciaDescricaoInvalidaException() {
        super("Descrição não pode ser nula ou vazia");
    }
}
