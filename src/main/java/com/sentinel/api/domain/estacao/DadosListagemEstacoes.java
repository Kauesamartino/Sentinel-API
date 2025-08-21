package com.sentinel.api.domain.estacao;

import com.sentinel.api.domain.endereco.Endereco;

public record DadosListagemEstacoes(
        Long id,
        String nome,
        Linha linha,
        Endereco endereco
) {
    public DadosListagemEstacoes(Estacao estacao){
        this(
                estacao.getId(),
                estacao.getNome(),
                estacao.getLinha(),
                estacao.getEndereco()
        );
    }
}
