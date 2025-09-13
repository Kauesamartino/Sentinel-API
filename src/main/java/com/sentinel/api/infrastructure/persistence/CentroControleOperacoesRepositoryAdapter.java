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

    @Override
    public CentroControleOperacoes save(CentroControleOperacoes centroControleOperacoes) {
        return null;
    }

    @Override
    public CentroControleOperacoes findById(Long idCco) {
        JpaCentroControleOperacoesEntity entity = jpaCentroControleOperacoesRepository.findById(idCco)
                .orElseThrow(() -> new IllegalArgumentException("Cco não encontrado"));
        return mapper.jpaEntityToDomain(entity);
    }
}
