package com.sentinel.api.infrastructure.persistence;

import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.domain.repository.CentroControleOperacoesRepository;
import com.sentinel.api.infrastructure.entity.JpaCentroControleOperacoesEntity;
import com.sentinel.api.infrastructure.repository.JpaCentroControleOperacoesRepository;
import com.sentinel.api.interfaces.mapper.CentroControleOperacoesMapper;

public final class CentroControleOperacoesRepositoryAdapter implements CentroControleOperacoesRepository {

    private final JpaCentroControleOperacoesRepository jpaCentroControleOperacoesRepository;

    public CentroControleOperacoesRepositoryAdapter(JpaCentroControleOperacoesRepository jpaCentroControleOperacoesRepository) {
        this.jpaCentroControleOperacoesRepository = jpaCentroControleOperacoesRepository;
    }

    public CentroControleOperacoes save(CentroControleOperacoes centroControleOperacoes) {
        JpaCentroControleOperacoesEntity entityToSave = CentroControleOperacoesMapper.domainToJpaEntity(centroControleOperacoes);
        JpaCentroControleOperacoesEntity savedEntity = jpaCentroControleOperacoesRepository.save(entityToSave);
        return CentroControleOperacoesMapper.jpaEntityToDomain(savedEntity);
    }

    public CentroControleOperacoes findById(Long idCco) {
        JpaCentroControleOperacoesEntity entity = jpaCentroControleOperacoesRepository.findById(idCco)
                .orElseThrow(() -> new IllegalArgumentException("Cco não encontrado"));
        return CentroControleOperacoesMapper.jpaEntityToDomain(entity);
    }
}
