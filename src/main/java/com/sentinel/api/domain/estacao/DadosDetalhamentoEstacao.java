package com.sentinel.api.domain.estacao;

import com.sentinel.api.domain.cco.CentroControleOperacoes;
import com.sentinel.api.domain.endereco.Endereco;

public record DadosDetalhamentoEstacao(
        Long id,
        String nome,
        String linha,
        CentroControleOperacoes centroControleOperacoes,
        Endereco endereco
) {
    public DadosDetalhamentoEstacao(Estacao estacao){
        this(estacao.getId(), estacao.getNome(), estacao.getLinha(), estacao.getControleOperacoes(), estacao.getEndereco());
    }
}
