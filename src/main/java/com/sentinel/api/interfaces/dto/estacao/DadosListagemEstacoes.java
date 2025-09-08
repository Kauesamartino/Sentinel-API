package com.sentinel.api.interfaces.dto.estacao;

import com.sentinel.api.domain.model.Endereco;
import com.sentinel.api.infrastructure.entity.JpaEstacaoEntity;
import com.sentinel.api.domain.enums.Linha;

public record DadosListagemEstacoes(
        Long id,
        String nome,
        Linha linha,
        Endereco endereco
) {
    public DadosListagemEstacoes(JpaEstacaoEntity jpaEstacaoEntity){
        this(
                jpaEstacaoEntity.getId(),
                jpaEstacaoEntity.getNome(),
                jpaEstacaoEntity.getLinha(),
                jpaEstacaoEntity.getEndereco()
        );
    }
}
