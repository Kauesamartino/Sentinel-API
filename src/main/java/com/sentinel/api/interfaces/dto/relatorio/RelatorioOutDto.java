package com.sentinel.api.interfaces.dto.relatorio;

import com.sentinel.api.domain.enums.TipoOcorrencia;

import java.time.LocalDateTime;

public record RelatorioOutDto(
        Long id,
        String titulo,
        String descricao,
        TipoOcorrencia tipoOcorrencia,
        LocalDateTime dataInicio,
        LocalDateTime dataFim
) {}
