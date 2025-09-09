package com.sentinel.api.interfaces.mapper;

import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.repository.CentroControleOperacoesRepository;
import com.sentinel.api.infrastructure.entity.JpaCentroControleOperacoesEntity;
import com.sentinel.api.infrastructure.entity.JpaEstacaoEntity;
import com.sentinel.api.interfaces.dto.cco.CcoOutDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoInDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstacaoMapper {
    private final CentroControleOperacoesRepository  centroControleOperacoesRepository;

    public Estacao inDtoToDomain(@Valid EstacaoInDto dados) {
        return new Estacao(dados);
    }

    public EstacaoOutDto domainToOutDto(Estacao estacao) {
        CcoOutDto ccoOutDto = null;
        if (estacao.getIdCco() != null) {
            CentroControleOperacoes centroControleOperacoes = centroControleOperacoesRepository.findById(estacao.getIdCco());
            ccoOutDto = new CcoOutDto(centroControleOperacoes);
        }
        return new EstacaoOutDto(estacao, ccoOutDto);
    }

    public Estacao jpaEntityToDomain(JpaEstacaoEntity jpaEstacaoEntity) {
        return new Estacao(
                jpaEstacaoEntity.getId(),
                jpaEstacaoEntity.getNome(),
                jpaEstacaoEntity.getLinha(),
                jpaEstacaoEntity.getJpaCentroControleOperacoesEntity().getId(),
                jpaEstacaoEntity.getEndereco()
        );
    }

    public JpaEstacaoEntity domainToJpaEntity(Estacao estacao, JpaCentroControleOperacoesEntity cco) {
        return new JpaEstacaoEntity(estacao, cco);
    }
}
