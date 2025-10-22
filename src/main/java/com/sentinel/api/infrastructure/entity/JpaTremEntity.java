package com.sentinel.api.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "trems")
@Entity(name = "trem")
@Getter
public class JpaTremEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroTrem;
    private Boolean ativo;

    public JpaTremEntity() {
    }

    public JpaTremEntity(Long id, String numeroTrem, Boolean ativo) {
        this.id = id;
        this.numeroTrem = numeroTrem;
        this.ativo = ativo;
    }
}
