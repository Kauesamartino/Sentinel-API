package com.sentinel.api.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "ccos")
@Entity(name = "CCO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class JpaCentroControleOperacoesEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public JpaCentroControleOperacoesEntity(String nome) {
        this.nome = nome;
    }
}
