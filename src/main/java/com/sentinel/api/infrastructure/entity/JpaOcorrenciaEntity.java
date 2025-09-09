package com.sentinel.api.infrastructure.entity;

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
public class JpaOcorrenciaEntity {

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
    private JpaEstacaoEntity jpaEstacaoEntity;

    private Boolean ativo;

    public JpaOcorrenciaEntity(String titulo, String descricao, LocalDateTime data, Severidade severidade, Status status, TipoOcorrencia tipoOcorrencia, JpaEstacaoEntity estacaoEntity, Boolean ativo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.severidade = severidade;
        this.status = status;
        this.tipoOcorrencia = tipoOcorrencia;
        this.jpaEstacaoEntity = estacaoEntity;
        this.ativo = ativo;
    }

}
