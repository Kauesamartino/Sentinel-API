package com.sentinel.api.domain.estacao;

import com.sentinel.api.domain.endereco.Endereco;
import com.sentinel.api.domain.cco.CentroControleOperacoes;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "estacoes")
@Entity(name = "Estacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Estacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Linha linha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cco_id")
    private CentroControleOperacoes controleOperacoes;

    @Embedded
    private Endereco endereco;

    public Estacao(DadosCadastroEstacao dados, CentroControleOperacoes controleOperacoes) {
        this.nome = dados.nome();
        this.linha = dados.linha();
        this.controleOperacoes = controleOperacoes;
        this.endereco = new Endereco(dados.endereco());
    }
}
