package com.sentinel.api.domain.cco;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCentroControleOperacoes(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome
) {
}
