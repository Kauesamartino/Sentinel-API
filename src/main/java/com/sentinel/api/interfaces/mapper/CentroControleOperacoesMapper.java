package com.sentinel.api.interfaces.mapper;

import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.infrastructure.entity.JpaCentroControleOperacoesEntity;
import com.sentinel.api.interfaces.dto.cco.CcoInDto;
import com.sentinel.api.interfaces.dto.cco.CcoOutDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class CentroControleOperacoesMapper {
    public CentroControleOperacoes jpaEntityToDomain(JpaCentroControleOperacoesEntity entity) {
        return new CentroControleOperacoes(
                entity.getId(),
                entity.getNome()
        );
    }

    public JpaCentroControleOperacoesEntity domainToJpaEntity(CentroControleOperacoes centroControleOperacoes) {
            return JpaCentroControleOperacoesEntity.builder()
                    .nome(centroControleOperacoes.getName())
                    .build();
    }

    public CentroControleOperacoes inDtoToDomain(@Valid CcoInDto dados) {
        return CentroControleOperacoes.builder()
                .name(dados.nome())
                .build();
    }

    public CcoOutDto domainToOutDto(CentroControleOperacoes centroControleOperacoes) {
        return new CcoOutDto(
                centroControleOperacoes.getId(),
                centroControleOperacoes.getName()
        );
    }
}
