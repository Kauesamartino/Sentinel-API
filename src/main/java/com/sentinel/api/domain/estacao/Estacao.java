package com.sentinel.api.domain.estacao;

import com.sentinel.api.domain.Endereco.Endereco;
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
    private String linha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cco_id")
    private CentroControleOperacoes controleOperacoes;

    @Embedded
    private Endereco endereco;
}
