package com.sentinel.api.interfaces.dto.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.enums.Severidade;
import com.sentinel.api.domain.enums.Status;
import com.sentinel.api.domain.enums.TipoOcorrencia;
import com.sentinel.api.interfaces.dto.camera.CameraOutDto;
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
        CameraOutDto cameraOutDto,
        Boolean ativo
) {
    public OcorrenciaOutDetailDto(Ocorrencia ocorrencia, EstacaoOutDto estacaoOutDto, CameraOutDto cameraOutDto) {
        this(
                ocorrencia.getId(),
                ocorrencia.getTitulo(),
                ocorrencia.getDescricao(),
                ocorrencia.getData(),
                ocorrencia.getSeveridade(),
                ocorrencia.getStatus(),
                ocorrencia.getTipoOcorrencia(),
                estacaoOutDto,
                cameraOutDto,
                ocorrencia.getAtivo());
    }
}
