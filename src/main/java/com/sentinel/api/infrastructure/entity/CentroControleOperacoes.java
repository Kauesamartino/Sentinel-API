package com.sentinel.api.infrastructure.entity;

import com.sentinel.api.interfaces.dto.cco.DadosCadastroCentroControleOperacoes;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "CCOs")
@Entity(name = "CCO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CentroControleOperacoes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public CentroControleOperacoes(DadosCadastroCentroControleOperacoes dados) {
        this.nome = dados.nome();
    }
}
