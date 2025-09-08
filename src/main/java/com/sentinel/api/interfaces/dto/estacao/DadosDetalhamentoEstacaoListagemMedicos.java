package com.sentinel.api.interfaces.dto.estacao;

import com.sentinel.api.domain.entity.Estacao;
import com.sentinel.api.domain.enums.Linha;

public record DadosDetalhamentoEstacaoListagemMedicos (
        String nome,
        Linha linha
){
    public DadosDetalhamentoEstacaoListagemMedicos(Estacao estacao){
        this(estacao.getNome(), estacao.getLinha());
    }
}
