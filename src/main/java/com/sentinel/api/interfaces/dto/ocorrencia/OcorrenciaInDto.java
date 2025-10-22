package com.sentinel.api.interfaces.dto.ocorrencia;


import com.sentinel.api.domain.enums.Severidade;
import com.sentinel.api.domain.enums.TipoOcorrencia;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record OcorrenciaInDto(
        @NotBlank(message = "{titulo.obrigatorio}")
        String titulo,

        @NotBlank(message = "{descricao.obrigatorio}")
        String descricao,

        @NotNull(message = "{severidade.obrigatorio}")
        Severidade severidade,
        Long idEstacao,
        Long idCamera,
        Boolean ativo,

        @NotNull(message = "{tipoOcorrencia.obrigatorio}")
        TipoOcorrencia tipoOcorrencia
) {
}
