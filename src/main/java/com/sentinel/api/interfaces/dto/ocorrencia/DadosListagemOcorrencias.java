package com.sentinel.api.interfaces.dto.ocorrencia;

import com.sentinel.api.infrastructure.entity.Ocorrencia;
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
    public DadosListagemOcorrencias(Ocorrencia ocorrencia){
        this(
                ocorrencia.getId(),
                ocorrencia.getTitulo(),
                ocorrencia.getTipoOcorrencia(),
                ocorrencia.getData(),
                ocorrencia.getSeveridade(),
                ocorrencia.getStatus()
        );
    }

}
