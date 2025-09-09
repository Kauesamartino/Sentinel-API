package com.sentinel.api.interfaces.dto.estacao;

import com.sentinel.api.domain.model.Endereco;
import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.enums.Linha;

public record EstacaoLazyOutDto(
        Long id,
        String nome,
        Linha linha,
        Endereco endereco
) {
    public EstacaoLazyOutDto(Estacao estacao){
        this(
                estacao.getId(),
                estacao.getNome(),
                estacao.getLinha(),
                estacao.getEndereco()
        );
    }
}
