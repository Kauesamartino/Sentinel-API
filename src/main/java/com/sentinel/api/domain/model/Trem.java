package com.sentinel.api.domain.model;

import com.sentinel.api.domain.exception.DomainValidationException;

public class Trem {

    private String numeroTrem;
    private Boolean ativo;

    public Trem(String numeroTrem) {
        setNumeroTrem(numeroTrem);
        this.ativo = true;
    }

    public void setNumeroTrem(String numeroTrem) {
        this.numeroTrem = numeroTrem;
        isNumeroTremValido(numeroTrem);
    }

    private void isNumeroTremValido(String numeroTrem) {
        if (numeroTrem == null || numeroTrem.isEmpty()) {
            throw new DomainValidationException("Número do trem inválido.");
        }
    }

}
