package com.sentinel.api.interfaces.dto.estacao;

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
}
