package com.sentinel.api.infrastructure.persistence;

import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.domain.repository.RelatorioRepository;
import com.sentinel.api.infrastructure.entity.JpaRelatorioEntity;
import com.sentinel.api.infrastructure.repository.JpaRelatorioRepository;
import com.sentinel.api.interfaces.mapper.RelatorioMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RelatorioRepositoryAdapter implements RelatorioRepository {

    private final JpaRelatorioRepository jpaRelatorioRepository;
    private final RelatorioMapper mapper;

    @Transactional
    public Relatorio save(Relatorio relatorio) {
        JpaRelatorioEntity relatorioEntity =  mapper.domainToJpaEntity(relatorio);
        JpaRelatorioEntity savedEntity = jpaRelatorioRepository.save(relatorioEntity);
        return mapper.jpaEntityToDomain(savedEntity);
    }

    public Page<Relatorio> findAll(Pageable pageable) {
        Page<JpaRelatorioEntity> entityPage = jpaRelatorioRepository.findAll(pageable);
        return entityPage.map(mapper::jpaEntityToDomain);
    }
}
