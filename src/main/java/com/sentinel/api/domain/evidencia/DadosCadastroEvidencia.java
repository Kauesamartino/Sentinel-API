package com.sentinel.api.domain.evidencia;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroEvidencia(
        @NotBlank(message = "{key.obrigatorio}")
        String key,
        @NotNull
        Long idOcorrencia
) {
}
