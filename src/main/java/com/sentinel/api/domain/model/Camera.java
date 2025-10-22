package com.sentinel.api.domain.model;

import com.sentinel.api.domain.exception.DomainValidationException;

public class Camera {

    private String codigo;
    private String modelo;
    private Long idCarro;
    private Boolean ativo;

    public Camera(String codigo, String modelo, Long idCarro) {
        setCodigo(codigo);
        setModelo(modelo);
        setIdCarro(idCarro);
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        isCodigoValido(codigo);
    }

    private void isCodigoValido(String codigo) {
        if (codigo == null || codigo.isEmpty()) {
            throw new DomainValidationException("Código da câmera não pode ser nulo ou vazio.");
        }
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
        isModeloValido(modelo);
    }

    private void isModeloValido(String modelo) {
        if (modelo == null || modelo.isEmpty()) {
            throw new DomainValidationException("Modelo da câmera não pode ser nulo ou vazio.");
        }
    }

    public void setIdCarro(Long idCarro) {
        this.idCarro = idCarro;
        isIdCarroValido(idCarro);
    }

    private void isIdCarroValido(Long idCarro) {
        if (idCarro == null) {
            throw new DomainValidationException("ID do carro não pode ser nulo.");
        }
    }


}
