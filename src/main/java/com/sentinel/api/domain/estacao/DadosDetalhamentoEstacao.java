package com.sentinel.api.domain.estacao;

import com.sentinel.api.domain.cco.CentroControleOperacoes;
import com.sentinel.api.domain.cco.DadosDetalhamentoCentroControleOperacoes;
import com.sentinel.api.domain.endereco.Endereco;

public record DadosDetalhamentoEstacao(
        Long id,
        String nome,
        String linha,
        DadosDetalhamentoCentroControleOperacoes dadosControle,
        Endereco endereco
) {
    public DadosDetalhamentoEstacao(Estacao estacao){
        this(estacao.getId(), estacao.getNome(), estacao.getLinha(), estacao.getControleOperacoes()!= null ? new DadosDetalhamentoCentroControleOperacoes(estacao.getControleOperacoes()) : null, estacao.getEndereco());
    }
}
