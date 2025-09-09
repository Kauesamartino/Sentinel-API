package com.sentinel.api.domain.model;

import com.sentinel.api.domain.enums.TipoOcorrencia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Relatorio {
    private Long id;
    private String titulo;
    private String descricao;
    private TipoOcorrencia tipoOcorrencia;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
}
