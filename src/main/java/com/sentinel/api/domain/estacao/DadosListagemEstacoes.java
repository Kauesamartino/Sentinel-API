package com.sentinel.api.domain.estacao;

import com.sentinel.api.domain.cco.DadosDetalhamentoCentroControleOperacoes;
import com.sentinel.api.domain.endereco.Endereco;

public record DadosListagemEstacoes(
        Long id,
        String nome,
        Linha linha,
        DadosDetalhamentoCentroControleOperacoes dadosDetalhamentoCentroControleOperacoes,
        Endereco endereco
) {
    public DadosListagemEstacoes(Estacao estacao){
        this(
                estacao.getId(),
                estacao.getNome(),
                estacao.getLinha(),
                estacao.getControleOperacoes() != null ? new DadosDetalhamentoCentroControleOperacoes(estacao.getControleOperacoes()) : null,
                estacao.getEndereco()
        );
    }
}
