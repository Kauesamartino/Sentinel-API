package com.sentinel.api.domain.cco;

public record DadosDetalhamentoCentroControleOperacoes(
        Long id,
        String nome
) {
    public DadosDetalhamentoCentroControleOperacoes(CentroControleOperacoes cco){
        this(cco.getId(), cco.getNome());
    }
}
