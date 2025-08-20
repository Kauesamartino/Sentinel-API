package com.sentinel.api.domain.ocorrencia;

import com.sentinel.api.domain.estacao.Estacao;

import java.time.LocalDateTime;

public record DadosDetalhamentoOcorrencia(
        Long id,
        String titulo,
        String descricao,
        LocalDateTime data,
        Severidade severidade,
        Status status,
        TipoOcorrencia tipoOcorrencia,
        Estacao estacao,
        Boolean ativo
) {
    public DadosDetalhamentoOcorrencia(Ocorrencia ocorrencia){
        this(ocorrencia.getId(), ocorrencia.getTitulo(), ocorrencia.getDescricao(), ocorrencia.getData(), ocorrencia.getSeveridade(), ocorrencia.getStatus(), ocorrencia.getTipoOcorrencia(), ocorrencia.getEstacao(), ocorrencia.getAtivo());
    }
}
