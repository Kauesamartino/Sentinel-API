package com.sentinel.api.domain.model;

import com.sentinel.api.domain.enums.Severidade;
import com.sentinel.api.domain.enums.Status;
import com.sentinel.api.domain.enums.TipoOcorrencia;
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
    private Long idCamera;
    private Boolean ativo;

    public Ocorrencia(String titulo, String descricao, Severidade severidade, TipoOcorrencia tipoOcorrencia, Long idEstacao, Long idCamera, Boolean ativo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = LocalDateTime.now();
        this.severidade = severidade;
        this.status = Status.ABERTO;
        this.tipoOcorrencia = tipoOcorrencia;
        this.idEstacao = idEstacao;
        this.idCamera = idCamera;
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

    public Ocorrencia(Long id, String titulo, String descricao, LocalDateTime data, Severidade severidade, Status status, TipoOcorrencia tipoOcorrencia, Long idEstacao, Boolean ativo) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.severidade = severidade;
        this.status = status;
        this.tipoOcorrencia = tipoOcorrencia;
        this.idEstacao = idEstacao;
        this.ativo = Objects.requireNonNullElse(ativo, false);
    }
}
