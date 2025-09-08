package com.sentinel.api.interfaces.dto.estacao;

import com.sentinel.api.infrastructure.entity.JpaEstacaoEntity;
import com.sentinel.api.domain.enums.Linha;

public record DadosDetalhamentoEstacaoListagemMedicos (
        String nome,
        Linha linha
){
    public DadosDetalhamentoEstacaoListagemMedicos(JpaEstacaoEntity jpaEstacaoEntity){
        this(jpaEstacaoEntity.getNome(), jpaEstacaoEntity.getLinha());
    }
}
