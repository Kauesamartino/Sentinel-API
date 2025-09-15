package com.sentinel.api.application.exceptions.ocorrencia;

public class OcorrenciaTituloInvalidoException extends RuntimeException {
    public OcorrenciaTituloInvalidoException() {
        super("O titulo da ocorrência não pode ser nulo ou vazio");
    }
}
