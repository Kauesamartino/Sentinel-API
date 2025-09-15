package com.sentinel.api.application.exceptions.ocorrencia;

public class OcorrenciaTipoInvalidoException extends RuntimeException {
    public OcorrenciaTipoInvalidoException() {
        super("Tipo da ocorrencia não pode ser nulo");
    }
}
