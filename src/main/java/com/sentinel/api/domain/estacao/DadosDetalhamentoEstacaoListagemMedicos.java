package com.sentinel.api.domain.estacao;

public record DadosDetalhamentoEstacaoListagemMedicos (
        String nome,
        Linha linha
){
    public DadosDetalhamentoEstacaoListagemMedicos(Estacao estacao){
        this(estacao.getNome(), estacao.getLinha());
    }
}
