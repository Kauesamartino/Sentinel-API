package com.sentinel.api.infrastructure.persistence;

import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.domain.repository.RelatorioRepository;
import com.sentinel.api.infrastructure.entity.JpaRelatorioEntity;
import com.sentinel.api.infrastructure.repository.JpaRelatorioRepository;
import com.sentinel.api.interfaces.mapper.RelatorioMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class RelatorioRepositoryAdapter implements RelatorioRepository {

    private final JpaRelatorioRepository jpaRelatorioRepository;

    public RelatorioRepositoryAdapter(JpaRelatorioRepository jpaRelatorioRepository) {
        this.jpaRelatorioRepository = jpaRelatorioRepository;
    }

    public Relatorio save(Relatorio relatorio) {
        JpaRelatorioEntity relatorioEntity =  RelatorioMapper.domainToJpaEntity(relatorio);
        JpaRelatorioEntity savedEntity = jpaRelatorioRepository.save(relatorioEntity);
        return RelatorioMapper.jpaEntityToDomain(savedEntity);
    }

    public Page<Relatorio> findAll(Pageable pageable) {
        Page<JpaRelatorioEntity> entityPage = jpaRelatorioRepository.findAll(pageable);
        return entityPage.map(RelatorioMapper::jpaEntityToDomain);
    }
}
