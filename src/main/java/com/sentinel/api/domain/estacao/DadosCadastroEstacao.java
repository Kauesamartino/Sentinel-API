package com.sentinel.api.domain.estacao;

import com.sentinel.api.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroEstacao(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,

        @NotNull(message = "{linha.obrigatorio}")
        Linha linha,

        @NotNull
        Long idCco,

        @NotNull(message = "{endereco.obrigatorio}")
        @Valid DadosEndereco endereco
) {
}
