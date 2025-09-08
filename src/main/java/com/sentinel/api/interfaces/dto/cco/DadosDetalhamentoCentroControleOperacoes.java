package com.sentinel.api.interfaces.dto.cco;

import com.sentinel.api.domain.entity.CentroControleOperacoes;

public record DadosDetalhamentoCentroControleOperacoes(
        Long id,
        String nome
) {
    public DadosDetalhamentoCentroControleOperacoes(CentroControleOperacoes cco){
        this(cco.getId(), cco.getNome());
    }
}
