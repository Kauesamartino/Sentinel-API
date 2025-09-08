package com.sentinel.api.interfaces.dto.estacao;

import com.sentinel.api.interfaces.dto.endereco.DadosEndereco;
import com.sentinel.api.domain.enums.Linha;
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
