package com.sentinel.api.domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CentroControleOperacoes {
    private Long id;
    private String name;

    public CentroControleOperacoes(String name) {
        this.name = name;
    }
}
