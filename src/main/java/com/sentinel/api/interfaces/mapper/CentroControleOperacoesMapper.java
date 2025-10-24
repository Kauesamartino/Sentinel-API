package com.sentinel.api.interfaces.mapper;

import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.infrastructure.entity.JpaCentroControleOperacoesEntity;
import com.sentinel.api.interfaces.dto.cco.CcoInDto;
import com.sentinel.api.interfaces.dto.cco.CcoOutDto;


public final class CentroControleOperacoesMapper {
    public static CentroControleOperacoes jpaEntityToDomain(JpaCentroControleOperacoesEntity entity) {
        return new CentroControleOperacoes(
                entity.getId(),
                entity.getNome()
        );
    }

    public static JpaCentroControleOperacoesEntity domainToJpaEntity(CentroControleOperacoes centroControleOperacoes) {
            return JpaCentroControleOperacoesEntity.builder()
                    .nome(centroControleOperacoes.getName())
                    .build();
    }

    public static CentroControleOperacoes inDtoToDomain(CcoInDto dados) {
        return CentroControleOperacoes.builder()
                .name(dados.nome())
                .build();
    }

    public static CcoOutDto domainToOutDto(CentroControleOperacoes centroControleOperacoes) {
        return new CcoOutDto(
                centroControleOperacoes.getId(),
                centroControleOperacoes.getName()
        );
    }
}
