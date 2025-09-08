package com.sentinel.api.infrastructure.entity;

import com.sentinel.api.domain.enums.Linha;
import com.sentinel.api.domain.model.Endereco;
import com.sentinel.api.interfaces.dto.estacao.DadosCadastroEstacao;
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
    private JpaCentroControleOperacoesEntity cco;

    @Embedded
    private Endereco endereco;

    public JpaEstacaoEntity(DadosCadastroEstacao dados, JpaCentroControleOperacoesEntity cco) {
        this.nome = dados.nome();
        this.linha = dados.linha();
        this.cco = cco;
        this.endereco = new Endereco(dados.endereco());
    }
}
