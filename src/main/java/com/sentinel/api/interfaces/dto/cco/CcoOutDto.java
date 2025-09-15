package com.sentinel.api.interfaces.dto.cco;
public record CcoOutDto(
        Long id,
        String nome
) {

    public CcoOutDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
