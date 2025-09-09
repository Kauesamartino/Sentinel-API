package com.sentinel.api.interfaces.dto.cco;

import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.infrastructure.entity.JpaCentroControleOperacoesEntity;

public record CcoOutDto(
        Long id,
        String nome
) {
    public CcoOutDto(JpaCentroControleOperacoesEntity cco){
        this(cco.getId(), cco.getNome());
    }

    public CcoOutDto(CentroControleOperacoes centroControleOperacoes) {
        this(
                centroControleOperacoes.getId(),
                centroControleOperacoes.getName()
        );
    }
}
