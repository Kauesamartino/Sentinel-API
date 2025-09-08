package com.sentinel.api.domain.entity;

import com.sentinel.api.application.usecases.ocorrencia.ports.CreateOcorrenciaInput;
import com.sentinel.api.domain.enums.Severidade;
import com.sentinel.api.domain.enums.Status;
import com.sentinel.api.domain.enums.TipoOcorrencia;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "ocorrencias")
@Entity(name = "Ocorrencia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class Ocorrencia {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private Severidade severidade;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private TipoOcorrencia tipoOcorrencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estacao_id")
    private Estacao estacao;

    private Boolean ativo;

    public Ocorrencia(CreateOcorrenciaInput input, Estacao estacao) {
        if (estacao == null) {
            throw new IllegalArgumentException("Estação é obrigatório");
        }
        if (input.ativo() == null) {
            this.ativo = false;
        } else {
            this.ativo = input.ativo();
        }

        this.titulo = input.titulo();
        this.descricao = input.descricao();
        this.estacao = estacao;
        this.data = LocalDateTime.now();
        this.severidade = input.severidade();
        this.status = Status.ABERTO;
        this.tipoOcorrencia = input.tipoOcorrencia();
    }


    public void excluir() {
        this.ativo = false;
    }
}
