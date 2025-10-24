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

    public Relatorio(String titulo, String descricao, TipoOcorrencia tipoOcorrencia, LocalDateTime dataInicio, LocalDateTime dataFim) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("Titulo é obrigatório");
        }
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição é obrigatória");
        }
        if (dataInicio == null) {
            throw new IllegalArgumentException("Data de inicio é obrigatória");
        }
        if (dataFim == null) {
            throw new IllegalArgumentException("Data do fim é obrigatória");
        }

        this.titulo = titulo;
        this.descricao = descricao;
        this.tipoOcorrencia = tipoOcorrencia;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
}
