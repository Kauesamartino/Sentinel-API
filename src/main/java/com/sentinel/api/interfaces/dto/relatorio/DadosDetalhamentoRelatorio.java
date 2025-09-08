package com.sentinel.api.interfaces.dto.relatorio;

import com.sentinel.api.domain.enums.TipoOcorrencia;
import com.sentinel.api.domain.entity.Relatorio;

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
