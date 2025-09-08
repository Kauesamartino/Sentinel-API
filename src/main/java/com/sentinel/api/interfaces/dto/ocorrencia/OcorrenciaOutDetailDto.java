package com.sentinel.api.interfaces.dto.ocorrencia;

import com.sentinel.api.infrastructure.entity.JpaOcorrenciaEntity;
import com.sentinel.api.domain.enums.Severidade;
import com.sentinel.api.domain.enums.Status;
import com.sentinel.api.domain.enums.TipoOcorrencia;
import com.sentinel.api.interfaces.dto.estacao.DadosDetalhamentoEstacao;

import java.time.LocalDateTime;

public record OcorrenciaOutDetailDto(
        Long id,
        String titulo,
        String descricao,
        LocalDateTime data,
        Severidade severidade,
        Status status,
        TipoOcorrencia tipoOcorrencia,
        DadosDetalhamentoEstacao dadosDetalhamentoEstacao,
        Boolean ativo
) {
    public OcorrenciaOutDetailDto(JpaOcorrenciaEntity jpaOcorrenciaEntity){
        this(
                jpaOcorrenciaEntity.getId(),
                jpaOcorrenciaEntity.getTitulo(),
                jpaOcorrenciaEntity.getDescricao(),
                jpaOcorrenciaEntity.getData(),
                jpaOcorrenciaEntity.getSeveridade(),
                jpaOcorrenciaEntity.getStatus(),
                jpaOcorrenciaEntity.getTipoOcorrencia(),
                jpaOcorrenciaEntity.getJpaEstacaoEntity() != null ? new DadosDetalhamentoEstacao(jpaOcorrenciaEntity.getJpaEstacaoEntity()) : null, jpaOcorrenciaEntity.getAtivo());
    }
}
