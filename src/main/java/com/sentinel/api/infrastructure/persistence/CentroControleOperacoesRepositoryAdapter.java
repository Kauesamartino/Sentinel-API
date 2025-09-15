package com.sentinel.api.infrastructure.persistence;

import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.domain.repository.CentroControleOperacoesRepository;
import com.sentinel.api.infrastructure.entity.JpaCentroControleOperacoesEntity;
import com.sentinel.api.infrastructure.repository.JpaCentroControleOperacoesRepository;
import com.sentinel.api.interfaces.mapper.CentroControleOperacoesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CentroControleOperacoesRepositoryAdapter implements CentroControleOperacoesRepository {

    private final JpaCentroControleOperacoesRepository jpaCentroControleOperacoesRepository;
    private final CentroControleOperacoesMapper mapper;

    public CentroControleOperacoes save(CentroControleOperacoes centroControleOperacoes) {
        JpaCentroControleOperacoesEntity entityToSave = mapper.domainToJpaEntity(centroControleOperacoes);
        JpaCentroControleOperacoesEntity savedEntity = jpaCentroControleOperacoesRepository.save(entityToSave);
        return mapper.jpaEntityToDomain(savedEntity);
    }

    public CentroControleOperacoes findById(Long idCco) {
        JpaCentroControleOperacoesEntity entity = jpaCentroControleOperacoesRepository.findById(idCco)
                .orElseThrow(() -> new IllegalArgumentException("Cco não encontrado"));
        return mapper.jpaEntityToDomain(entity);
    }
}
