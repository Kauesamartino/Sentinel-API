package com.sentinel.api.domain.model;

import com.sentinel.api.domain.enums.Severidade;
import com.sentinel.api.domain.enums.Status;
import com.sentinel.api.domain.enums.TipoOcorrencia;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaInDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Ocorrencia {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime data;
    private Severidade severidade;
    private Status status;
    private TipoOcorrencia tipoOcorrencia;
    private Long idEstacao;
    private Boolean ativo;

    public Ocorrencia(OcorrenciaInDto dados) {
        if (dados.titulo() == null || dados.titulo().isEmpty()) {
            throw new IllegalArgumentException("O titulo do ocorrência não pode ser nulo ou vazio.");
        }
        if (dados.descricao() == null || dados.descricao().isEmpty()) {
            throw new IllegalArgumentException("A descrição do ocorrência não pode ser nula ou vazia.");
        }

        if (dados.severidade() == null) {
            throw new IllegalArgumentException("A severidade da ocorrência não pode ser nula ou vazia.");
        }
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.severidade = dados.severidade();
        this.data = Objects.requireNonNullElseGet(data, LocalDateTime::now);
        this.status = Status.ABERTO;
        this.tipoOcorrencia = dados.tipoOcorrencia();
        this.idEstacao = dados.idEstacao();
        this.ativo = Objects.requireNonNullElse(ativo, false);
    }


    public Ocorrencia(String titulo, String descricao, Status status, TipoOcorrencia tipoOcorrencia, Severidade severidade, Boolean ativo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.tipoOcorrencia = tipoOcorrencia;
        this.severidade = severidade;
        this.ativo = ativo;
    }
}
