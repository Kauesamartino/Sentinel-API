package com.sentinel.api.interfaces.dto.relatorio;

import com.sentinel.api.domain.enums.TipoOcorrencia;
import com.sentinel.api.infrastructure.entity.JpaRelatorioEntity;

import java.time.LocalDateTime;

public record DadosListagemRelatorios(
        Long id,
        String titulo,
        String descricao,
        TipoOcorrencia tipoOcorrencia,
        LocalDateTime dataInicio,
        LocalDateTime dataFim
) {
    public DadosListagemRelatorios(JpaRelatorioEntity jpaRelatorioEntity) {
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
