package com.sentinel.api.domain.ocorrencia;

import java.time.LocalDateTime;

public record DadosDetalhamentoOcorrencia(
        Long id,
        String titulo,
        String descricao,
        LocalDateTime data,
        Severidade severidade,
        Status status,
        TipoOcorrencia tipoOcorrencia,
        Boolean ativo
) {
    public DadosDetalhamentoOcorrencia(Ocorrencia ocorrencia){
        this(ocorrencia.getId(), ocorrencia.getTitulo(), ocorrencia.getDescricao(), ocorrencia.getData(), ocorrencia.getSeveridade(), ocorrencia.getStatus(), ocorrencia.getTipoOcorrencia(), ocorrencia.getAtivo());
    }
}
