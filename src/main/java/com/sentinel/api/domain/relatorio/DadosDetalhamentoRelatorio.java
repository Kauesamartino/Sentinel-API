package com.sentinel.api.domain.relatorio;

import com.sentinel.api.domain.ocorrencia.TipoOcorrencia;

import java.time.LocalDateTime;

public record DadosDetalhamentoRelatorio(
        Long id,
        String titulo,
        String descricao,
        TipoOcorrencia tipoOcorrencia,
        LocalDateTime dataInicio,
        LocalDateTime dataFim
) {
    public DadosDetalhamentoRelatorio(Relatorio relatorio){
        this(
                relatorio.getId(),
                relatorio.getTitulo(),
                relatorio.getDescricao(),
                relatorio.getTipoOcorrencia(),
                relatorio.getDataInicio(),
                relatorio.getDataFim()
        );
    }
}
