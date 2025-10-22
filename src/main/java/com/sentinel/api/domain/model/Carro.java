package com.sentinel.api.domain.model;

import com.sentinel.api.domain.exception.DomainValidationException;

import java.time.LocalDate;

public class Carro {

    private String placa;
    private Integer anoFabricacao;
    private Long idTrem;
    private Boolean ativo;

    public Carro(String placa, Integer anoFabricacao, Long idTrem) {
        setPlaca(placa);
        setAnoFabricacao(anoFabricacao);
        setIdTrem(idTrem);
        this.ativo = true;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
        isPlacaValida(placa);
    }

    private void isPlacaValida(String placa) {
        // Verifica se a placa é nula ou vazia
        if (placa == null || placa.isEmpty()) {
            throw new DomainValidationException("A placa do carro não pode ser nula ou vázia.");
        }
    }


    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
        isAnoFabricacaoValido(anoFabricacao);
    }

    private void isAnoFabricacaoValido(Integer anoFabricacao) {
        // Verifica se o ano de fabricação é nulo ou está no futuro
        if (anoFabricacao == null || anoFabricacao.compareTo(LocalDate.now().getYear()) > 0) {
            throw new DomainValidationException("O ano de fabricação do carro é inválido.");
        }

        // Verifica se o ano de fabricação esta no intervalo aceitável
        if (anoFabricacao < 1900) {
            throw new DomainValidationException("O ano de fabricação do carro é inválido.");
        }
    }


    public void setIdTrem(Long idTrem) {
        this.idTrem = idTrem;
        isIdTremValido(idTrem);
    }

    private void isIdTremValido(Long idTrem) {
        if (idTrem == null) {
            throw new DomainValidationException("O id do trem não pode ser nulo.");
        }
    }

}
