package com.sentinel.api.interfaces.dto.estacao;

import com.sentinel.api.interfaces.dto.cco.DadosDetalhamentoCentroControleOperacoes;
import com.sentinel.api.domain.entity.Endereco;
import com.sentinel.api.domain.entity.Estacao;
import com.sentinel.api.domain.enums.Linha;

public record DadosDetalhamentoEstacao(
        Long id,
        String nome,
        Linha linha,
        DadosDetalhamentoCentroControleOperacoes dadosControle,
        Endereco endereco
) {
    public DadosDetalhamentoEstacao(Estacao estacao){
        this(estacao.getId(), estacao.getNome(), estacao.getLinha(), estacao.getCco()!= null ? new DadosDetalhamentoCentroControleOperacoes(estacao.getCco()) : null, estacao.getEndereco());
    }
}
