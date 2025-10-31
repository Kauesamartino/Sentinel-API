package com.sentinel.api.interfaces.dto.estacao;

import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.interfaces.dto.cco.CcoOutDto;
import com.sentinel.api.domain.model.Endereco;
import com.sentinel.api.domain.enums.Linha;

public record EstacaoOutDto(
        Long id,
        String nome,
        Linha linha,
        CcoOutDto ccoOutDto,
        Endereco endereco
) {
    public EstacaoOutDto(Long id, String nome, Linha linha, CcoOutDto ccoOutDto, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.linha = linha;
        this.ccoOutDto = ccoOutDto;
        this.endereco = endereco;
    }

}
