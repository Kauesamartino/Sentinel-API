package com.sentinel.api.interfaces.dto.cco;

import jakarta.validation.constraints.NotBlank;

public record CcoInDto(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome
) {
}
