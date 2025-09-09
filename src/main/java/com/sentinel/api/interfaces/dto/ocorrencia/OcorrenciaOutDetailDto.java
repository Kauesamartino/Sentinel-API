package com.sentinel.api.interfaces.dto.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.enums.Severidade;
import com.sentinel.api.domain.enums.Status;
import com.sentinel.api.domain.enums.TipoOcorrencia;
import com.sentinel.api.interfaces.dto.estacao.EstacaoOutDto;

import java.time.LocalDateTime;

public record OcorrenciaOutDetailDto(
        Long id,
        String titulo,
        String descricao,
        LocalDateTime data,
        Severidade severidade,
        Status status,
        TipoOcorrencia tipoOcorrencia,
        EstacaoOutDto estacaoOutDto,
        Boolean ativo
) {
    public OcorrenciaOutDetailDto(Ocorrencia ocorrencia, EstacaoOutDto estacaoOutDto) {
        this(
                ocorrencia.getId(),
                ocorrencia.getTitulo(),
                ocorrencia.getDescricao(),
                ocorrencia.getData(),
                ocorrencia.getSeveridade(),
                ocorrencia.getStatus(),
                ocorrencia.getTipoOcorrencia(),
                estacaoOutDto,
                ocorrencia.getAtivo());
    }
}
