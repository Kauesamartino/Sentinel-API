package com.sentinel.api.interfaces.mapper;

import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.infrastructure.entity.JpaCentroControleOperacoesEntity;
import org.springframework.stereotype.Component;

@Component
public class CentroControleOperacoesMapper {
    public CentroControleOperacoes jpaEntityToDomain(JpaCentroControleOperacoesEntity entity) {
        return new CentroControleOperacoes(
                entity.getId(),
                entity.getNome()
        );
    }
}
