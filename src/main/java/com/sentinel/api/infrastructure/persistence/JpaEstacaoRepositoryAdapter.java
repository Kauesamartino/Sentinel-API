package com.sentinel.api.infrastructure.persistence;

import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.repository.EstacaoRepository;
import com.sentinel.api.infrastructure.entity.JpaCentroControleOperacoesEntity;
import com.sentinel.api.infrastructure.entity.JpaEstacaoEntity;
import com.sentinel.api.infrastructure.repository.JpaCentroControleOperacoesRepository;
import com.sentinel.api.infrastructure.repository.JpaEstacaoRepository;
import com.sentinel.api.interfaces.mapper.EstacaoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaEstacaoRepositoryAdapter implements EstacaoRepository {

    private final JpaEstacaoRepository jpaEstacaoRepository;
    private final JpaCentroControleOperacoesRepository  jpaCentroControleOperacoesRepository;
    private final EstacaoMapper mapper;

    @Transactional
    public Estacao save(Estacao estacao) {
        JpaCentroControleOperacoesEntity cco = jpaCentroControleOperacoesRepository.getReferenceById(estacao.getIdCco());
        JpaEstacaoEntity entity = mapper.domainToJpaEntity(estacao, cco);
        JpaEstacaoEntity savedEntity = jpaEstacaoRepository.save(entity);
        return mapper.jpaEntityToDomain(savedEntity);
    }

    public Estacao findById(Long idEstacao) {
        JpaEstacaoEntity jpaEstacaoEntity = jpaEstacaoRepository.findById(idEstacao)
                .orElseThrow(() -> new IllegalArgumentException("Estação não encontrada"));
        return mapper.jpaEntityToDomain(jpaEstacaoEntity);
    }

    public Page<Estacao> findAll(Pageable pageable) {
        Page<JpaEstacaoEntity> jpaEstacaoEntity = jpaEstacaoRepository.findAll(pageable);
        return jpaEstacaoEntity.map(mapper::jpaEntityToDomain);
    }
}
