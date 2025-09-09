package com.sentinel.api.interfaces.dto.estacao;

import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.interfaces.dto.cco.CcoOutDto;
import com.sentinel.api.domain.model.Endereco;
import com.sentinel.api.domain.enums.Linha;

public record EstacaoOutDto(
        Long id,
        String nome,
        Linha linha,
        CcoOutDto dadosControle,
        Endereco endereco
) {
    public EstacaoOutDto(Estacao estacao, CcoOutDto ccoOutDto) {
        this(
                estacao.getId(),
                estacao.getNome(),
                estacao.getLinha(),
                ccoOutDto,
                estacao.getEndereco()
        );
    }

}
