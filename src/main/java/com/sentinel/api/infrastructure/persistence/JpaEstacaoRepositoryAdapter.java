package com.sentinel.api.infrastructure.persistence;

import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.repository.EstacaoRepository;
import com.sentinel.api.infrastructure.entity.JpaEstacaoEntity;
import com.sentinel.api.infrastructure.repository.JpaEstacaoRepository;
import com.sentinel.api.interfaces.mapper.EstacaoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaEstacaoRepositoryAdapter implements EstacaoRepository {

    private final JpaEstacaoRepository jpaEstacaoRepository;
    private final EstacaoMapper mapper;

    @Transactional
    public Estacao save(Estacao estacao) {

        return null;
    }

    @Override
    public Estacao findById(Long idEstacao) {
        JpaEstacaoEntity jpaEstacaoEntity = jpaEstacaoRepository.findById(idEstacao)
                .orElseThrow(() -> new IllegalArgumentException("Estação não encontrada"));
        return mapper.jpaEntityToDomain(jpaEstacaoEntity);
    }
}
