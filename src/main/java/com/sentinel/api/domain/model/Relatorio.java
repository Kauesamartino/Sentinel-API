package com.sentinel.api.domain.model;

import com.sentinel.api.domain.enums.TipoOcorrencia;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioInDto;
import jakarta.validation.Valid;
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

    public Relatorio(@Valid RelatorioInDto dados) {
        if (dados.titulo() == null || dados.titulo().isEmpty()) {
            throw new IllegalArgumentException("Titulo é obrigatório");
        }
        if (dados.descricao() == null || dados.descricao().isEmpty()) {
            throw new IllegalArgumentException("Descrição é obrigatória");
        }
        if (dados.dataInicio() == null) {
            throw new IllegalArgumentException("Data de inicio é obrigatória");
        }
        if (dados.dataFim() == null) {
            throw new IllegalArgumentException("Data do fim é obrigatória");
        }

        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.tipoOcorrencia = dados.tipoOcorrencia();
        this.dataInicio = dados.dataInicio();
        this.dataFim = dados.dataFim();
    }
}
