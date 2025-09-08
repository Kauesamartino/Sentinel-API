package com.sentinel.api.interfaces.dto.ocorrencia;

import com.sentinel.api.infrastructure.entity.JpaOcorrenciaEntity;
import com.sentinel.api.domain.enums.Severidade;
import com.sentinel.api.domain.enums.Status;
import com.sentinel.api.domain.enums.TipoOcorrencia;

import java.time.LocalDateTime;

public record DadosListagemOcorrencias(
        Long id,
        String titulo,
        TipoOcorrencia tipoOcorrencia,
        LocalDateTime data,
        Severidade severidade,
        Status status
) {
    public DadosListagemOcorrencias(JpaOcorrenciaEntity jpaOcorrenciaEntity){
        this(
                jpaOcorrenciaEntity.getId(),
                jpaOcorrenciaEntity.getTitulo(),
                jpaOcorrenciaEntity.getTipoOcorrencia(),
                jpaOcorrenciaEntity.getData(),
                jpaOcorrenciaEntity.getSeveridade(),
                jpaOcorrenciaEntity.getStatus()
        );
    }

}
