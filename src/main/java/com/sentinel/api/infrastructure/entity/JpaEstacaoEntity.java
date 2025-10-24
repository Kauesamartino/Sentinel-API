package com.sentinel.api.infrastructure.entity;

import com.sentinel.api.domain.enums.Linha;
import com.sentinel.api.domain.model.Endereco;
import com.sentinel.api.domain.model.Estacao;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "estacoes")
@Entity(name = "Estacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class JpaEstacaoEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Linha linha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cco_id")
    private JpaCentroControleOperacoesEntity jpaCentroControleOperacoesEntity;

    @Embedded
    private Endereco endereco;

    public JpaEstacaoEntity(String nome, Linha linha, JpaCentroControleOperacoesEntity cco, Endereco endereco) {
        this.nome = nome;
        this.linha = linha;
        this.jpaCentroControleOperacoesEntity = cco;
        this.endereco = endereco;
    }


}
