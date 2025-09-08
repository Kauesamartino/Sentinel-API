package com.sentinel.api.interfaces.dto.estacao;

import com.sentinel.api.domain.entity.Endereco;
import com.sentinel.api.infrastructure.entity.Estacao;
import com.sentinel.api.domain.enums.Linha;

public record DadosListagemEstacoes(
        Long id,
        String nome,
        Linha linha,
        Endereco endereco
) {
    public DadosListagemEstacoes(Estacao estacao){
        this(
                estacao.getId(),
                estacao.getNome(),
                estacao.getLinha(),
                estacao.getEndereco()
        );
    }
}
