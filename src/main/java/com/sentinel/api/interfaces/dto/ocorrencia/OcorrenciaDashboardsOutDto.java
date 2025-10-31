package com.sentinel.api.interfaces.dto.ocorrencia;

import com.sentinel.api.domain.enums.Status;
import com.sentinel.api.domain.enums.TipoOcorrencia;

import java.time.LocalDateTime;

public record OcorrenciaDashboardsOutDto(
        String titulo,
        TipoOcorrencia tipoOcorrencia,
        Status status,
        LocalDateTime data
){

}
