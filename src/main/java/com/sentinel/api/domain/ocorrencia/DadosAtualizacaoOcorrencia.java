package com.sentinel.api.domain.ocorrencia;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoOcorrencia(
        @NotNull Long id,
        String titulo,
        String descricao,
        Status status,
        TipoOcorrencia tipoOcorrencia
) {
}
