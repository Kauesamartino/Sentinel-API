package com.sentinel.api.interfaces.dto.ocorrencia;

import com.sentinel.api.domain.enums.Status;
import com.sentinel.api.domain.enums.TipoOcorrencia;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoOcorrencia(
        @NotNull Long id,
        String titulo,
        String descricao,
        Status status,
        TipoOcorrencia tipoOcorrencia
) {
}
