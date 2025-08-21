package com.sentinel.api.domain.ocorrencia;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroOcorrencia(
        @NotBlank(message = "{titulo.obrigatorio}")
        String titulo,

        @NotBlank(message = "{descricao.obrigatorio}")
        String descricao,

        @NotNull(message = "{severidade.obrigatorio}")
        Severidade severidade,

        @NotNull(message = "{tipoOcorrencia.obrigatorio}")
        TipoOcorrencia tipoOcorrencia
) {
}
