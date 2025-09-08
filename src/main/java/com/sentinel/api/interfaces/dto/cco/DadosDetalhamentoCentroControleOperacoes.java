package com.sentinel.api.interfaces.dto.cco;

import com.sentinel.api.infrastructure.entity.JpaCentroControleOperacoesEntity;

public record DadosDetalhamentoCentroControleOperacoes(
        Long id,
        String nome
) {
    public DadosDetalhamentoCentroControleOperacoes(JpaCentroControleOperacoesEntity cco){
        this(cco.getId(), cco.getNome());
    }
}
