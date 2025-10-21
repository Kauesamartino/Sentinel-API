package com.sentinel.api.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "cameras")
@Entity(name = "camera")
@Getter
public class JpaCameraEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String modelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carro_id")
    private JpaCarroEntity jpaCarroEntity;

    private Boolean ativo;

    public JpaCameraEntity() {
    }

    public JpaCameraEntity(Long id, String codigo, String modelo, JpaCarroEntity jpaCarroEntity, Boolean ativo) {
        this.id = id;
        this.codigo = codigo;
        this.modelo = modelo;
        this.jpaCarroEntity = jpaCarroEntity;
        this.ativo = ativo;
    }
}
