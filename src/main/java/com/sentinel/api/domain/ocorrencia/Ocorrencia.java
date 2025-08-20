package com.sentinel.api.domain.ocorrencia;

import com.sentinel.api.domain.estacao.Estacao;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "ocorrencias")
@Entity(name = "Ocorrencia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public Ocorrencia(DadosCadastroOcorrencia dados, Estacao estacao) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.data = LocalDateTime.now();
        this.severidade = dados.severidade();
        this.tipoOcorrencia = dados.tipoOcorrencia();
        this.estacao = estacao;
        this.ativo = true;
        this.status = Status.ABERTO;
    }
}
