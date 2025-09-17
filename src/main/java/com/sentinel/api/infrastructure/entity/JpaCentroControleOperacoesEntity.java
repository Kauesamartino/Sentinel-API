package com.sentinel.api.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "ccos")
@Entity(name = "CCO")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class JpaCentroControleOperacoesEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}
