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
            return new JpaCentroControleOperacoesEntity(
                    centroControleOperacoes.getName()
            );
    }

    public static CentroControleOperacoes inDtoToDomain(CcoInDto dados) {
        return new CentroControleOperacoes(
                dados.nome()
        );
    }

    public static CcoOutDto domainToOutDto(CentroControleOperacoes centroControleOperacoes) {
        return new CcoOutDto(
                centroControleOperacoes.getId(),
                centroControleOperacoes.getName()
        );
    }
}
