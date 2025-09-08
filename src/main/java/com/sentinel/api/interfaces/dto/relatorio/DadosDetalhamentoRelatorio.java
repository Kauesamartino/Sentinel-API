package com.sentinel.api.interfaces.dto.relatorio;

import com.sentinel.api.domain.enums.TipoOcorrencia;
import com.sentinel.api.infrastructure.entity.JpaRelatorioEntity;

import java.time.LocalDateTime;

public record DadosDetalhamentoRelatorio(
        Long id,
        String titulo,
        String descricao,
        TipoOcorrencia tipoOcorrencia,
        LocalDateTime dataInicio,
        LocalDateTime dataFim
) {
    public DadosDetalhamentoRelatorio(JpaRelatorioEntity jpaRelatorioEntity){
        this(
                jpaRelatorioEntity.getId(),
                jpaRelatorioEntity.getTitulo(),
                jpaRelatorioEntity.getDescricao(),
                jpaRelatorioEntity.getTipoOcorrencia(),
                jpaRelatorioEntity.getDataInicio(),
                jpaRelatorioEntity.getDataFim()
        );
    }
}
