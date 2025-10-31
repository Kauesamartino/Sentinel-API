package com.sentinel.api.infrastructure.persistence;

import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.repository.EstacaoRepository;
import com.sentinel.api.infrastructure.entity.JpaCentroControleOperacoesEntity;
import com.sentinel.api.infrastructure.entity.JpaEstacaoEntity;
import com.sentinel.api.infrastructure.repository.JpaCentroControleOperacoesRepository;
import com.sentinel.api.infrastructure.repository.JpaEstacaoRepository;
import com.sentinel.api.interfaces.mapper.EstacaoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class EstacaoRepositoryAdapter implements EstacaoRepository {

    private final JpaEstacaoRepository jpaEstacaoRepository;
    private final JpaCentroControleOperacoesRepository  jpaCentroControleOperacoesRepository;

    public EstacaoRepositoryAdapter(JpaEstacaoRepository jpaEstacaoRepository, JpaCentroControleOperacoesRepository jpaCentroControleOperacoesRepository) {
        this.jpaEstacaoRepository = jpaEstacaoRepository;
        this.jpaCentroControleOperacoesRepository = jpaCentroControleOperacoesRepository;
    }

    public Estacao save(Estacao estacao) {
        JpaCentroControleOperacoesEntity cco = jpaCentroControleOperacoesRepository.getReferenceById(estacao.getIdCco());
        JpaEstacaoEntity entity = EstacaoMapper.domainToJpaEntity(estacao, cco);
        JpaEstacaoEntity savedEntity = jpaEstacaoRepository.save(entity);
        return EstacaoMapper.jpaEntityToDomain(savedEntity);
    }

    public Estacao findById(Long idEstacao) {
        JpaEstacaoEntity jpaEstacaoEntity = jpaEstacaoRepository.findById(idEstacao)
                .orElseThrow(() -> new IllegalArgumentException("Estação não encontrada"));
        return EstacaoMapper.jpaEntityToDomain(jpaEstacaoEntity);
    }

    public Page<Estacao> findAll(Pageable pageable) {
        Page<JpaEstacaoEntity> jpaEstacaoEntity = jpaEstacaoRepository.findAll(pageable);
        return jpaEstacaoEntity.map(EstacaoMapper::jpaEntityToDomain);
    }

    public void delete(Long id) {
        jpaEstacaoRepository.deleteById(id);
    }
}
