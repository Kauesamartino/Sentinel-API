package com.sentinel.api.interfaces.dto.ocorrencia;

import com.sentinel.api.domain.enums.Severidade;
import com.sentinel.api.domain.enums.Status;
import com.sentinel.api.domain.enums.TipoOcorrencia;
import jakarta.validation.constraints.NotNull;

public record OcorrenciaUpdateDto(
        String titulo,
        String descricao,
        Status status,
        TipoOcorrencia tipoOcorrencia,
        Severidade severidade,
        Boolean ativo
) {
}
