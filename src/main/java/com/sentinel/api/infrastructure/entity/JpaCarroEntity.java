package com.sentinel.api.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "carros")
@Entity(name = "carro")
@Getter
public class JpaCarroEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trem_id")
    private JpaTremEntity jpaTremEntity;

    private Boolean ativo;

    public JpaCarroEntity() {
    }

    public JpaCarroEntity(Long id, String placa, JpaTremEntity jpaTremEntity, Boolean ativo) {
        this.id = id;
        this.placa = placa;
        this.jpaTremEntity = jpaTremEntity;
        this.ativo = ativo;
    }
}
