package com.sentinel.api.interfaces.dto.estacao;

import com.sentinel.api.interfaces.dto.cco.DadosDetalhamentoCentroControleOperacoes;
import com.sentinel.api.domain.model.Endereco;
import com.sentinel.api.infrastructure.entity.JpaEstacaoEntity;
import com.sentinel.api.domain.enums.Linha;

public record DadosDetalhamentoEstacao(
        Long id,
        String nome,
        Linha linha,
        DadosDetalhamentoCentroControleOperacoes dadosControle,
        Endereco endereco
) {
    public DadosDetalhamentoEstacao(JpaEstacaoEntity jpaEstacaoEntity){
        this(jpaEstacaoEntity.getId(), jpaEstacaoEntity.getNome(), jpaEstacaoEntity.getLinha(), jpaEstacaoEntity.getCco()!= null ? new DadosDetalhamentoCentroControleOperacoes(jpaEstacaoEntity.getCco()) : null, jpaEstacaoEntity.getEndereco());
    }
}
