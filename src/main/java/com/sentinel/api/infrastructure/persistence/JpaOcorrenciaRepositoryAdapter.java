package com.sentinel.api.infrastructure.persistence;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;
import com.sentinel.api.infrastructure.entity.JpaEstacaoEntity;
import com.sentinel.api.infrastructure.entity.JpaOcorrenciaEntity;
import com.sentinel.api.infrastructure.entity.JpaRelatorioEntity;
import com.sentinel.api.infrastructure.repository.JpaEstacaoRepository;
import com.sentinel.api.infrastructure.repository.JpaOcorrenciaRepository;
import com.sentinel.api.infrastructure.repository.JpaRelatorioRepository;
import com.sentinel.api.interfaces.mapper.OcorrenciaMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaOcorrenciaRepositoryAdapter implements OcorrenciaRepository {

    private final JpaOcorrenciaRepository jpaOcorrenciaRepository;
    private final OcorrenciaMapper mapper;
    private final JpaEstacaoRepository jpaEstacaoRepository;
    private final JpaRelatorioRepository jpaRelatorioRepository;

    @Transactional
    public Ocorrencia save(Ocorrencia ocorrencia) {
        JpaEstacaoEntity estacao = jpaEstacaoRepository.getReferenceById(ocorrencia.getIdEstacao());
        JpaOcorrenciaEntity entity = mapper.domainToJpa(ocorrencia, estacao);
        JpaOcorrenciaEntity savedEntity = jpaOcorrenciaRepository.save(entity);
        return mapper.jpaEntityToDomain(savedEntity);
    }

    @Transactional
    public Ocorrencia findById(Long id) {
        JpaOcorrenciaEntity entity = jpaOcorrenciaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ocorrência não encontrada"));
        return mapper.jpaEntityToDomain(entity);
    }

    @Transactional
    public Page<Ocorrencia> findAllByAtivoTrue(Pageable pageable) {
        Page<JpaOcorrenciaEntity> entityPage = jpaOcorrenciaRepository.findAllByAtivoTrue(pageable);
        return entityPage.map(mapper::jpaEntityToDomain);
    }

    @Transactional
    public void delete(Long id) {
        JpaOcorrenciaEntity jpaOcorrenciaEntity = jpaOcorrenciaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ocorrência não encontrada"));
        jpaOcorrenciaRepository.delete(jpaOcorrenciaEntity);
    }

    @Override
    public Page<Ocorrencia> findByDataBetweenAndTipoOcorrenciaOptional(Long id, Pageable pageable) {

        JpaRelatorioEntity relatorio = jpaRelatorioRepository.getReferenceById(id);
        Page<JpaOcorrenciaEntity> entityPage = jpaOcorrenciaRepository.findByDataBetweenAndTipoOcorrenciaOptional(
                relatorio.getDataInicio(),
                relatorio.getDataFim(),
                relatorio.getTipoOcorrencia(),
                pageable
        );

        return entityPage.map(mapper::jpaEntityToDomain);
    }
}
