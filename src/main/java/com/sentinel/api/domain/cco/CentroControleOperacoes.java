package com.sentinel.api.domain.cco;

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


}
