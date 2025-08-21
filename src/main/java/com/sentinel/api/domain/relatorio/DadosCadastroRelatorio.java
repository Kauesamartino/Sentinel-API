package com.sentinel.api.domain.relatorio;

import com.sentinel.api.domain.ocorrencia.TipoOcorrencia;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DadosCadastroRelatorio(
        @NotBlank(message = "{titulo.obrigatorio}")
        String titulo,

        @NotBlank(message = "{descricao.obrigatorio}")
        String descricao,

        TipoOcorrencia tipoOcorrencia,

        @NotBlank(message = "{data_inicio.obrigatorio}")
        LocalDateTime dataInicio,

        @NotBlank(message = "{data_fim.obrigatorio}")
        LocalDateTime dataFim
) {
}
