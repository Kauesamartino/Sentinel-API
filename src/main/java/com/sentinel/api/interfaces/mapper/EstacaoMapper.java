package com.sentinel.api.interfaces.mapper;

import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.infrastructure.entity.JpaCentroControleOperacoesEntity;
import com.sentinel.api.infrastructure.entity.JpaEstacaoEntity;
import com.sentinel.api.interfaces.dto.cco.CcoOutDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoInDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoOutDto;

public final class EstacaoMapper {

    public static Estacao inDtoToDomain(EstacaoInDto dados) {
        return new Estacao(dados);
    }

    public static EstacaoOutDto domainToOutDto(Estacao estacao, CentroControleOperacoes cco) {
        CcoOutDto ccoOutDto = new CcoOutDto(
                cco.getId(),
                cco.getName()
        );
        return new EstacaoOutDto(
                estacao.getId(),
                estacao.getNome(),
                estacao.getLinha(),
                ccoOutDto,
                estacao.getEndereco()
        );
    }

    public static Estacao jpaEntityToDomain(JpaEstacaoEntity jpaEstacaoEntity) {
        return new Estacao(
                jpaEstacaoEntity.getId(),
                jpaEstacaoEntity.getNome(),
                jpaEstacaoEntity.getLinha(),
                jpaEstacaoEntity.getJpaCentroControleOperacoesEntity().getId(),
                jpaEstacaoEntity.getEndereco()
        );
    }

    public static JpaEstacaoEntity domainToJpaEntity(Estacao estacao, JpaCentroControleOperacoesEntity cco) {
        return new JpaEstacaoEntity(
                estacao.getNome(),
                estacao.getLinha(),
                cco,
                estacao.getEndereco()
        );
    }
}
