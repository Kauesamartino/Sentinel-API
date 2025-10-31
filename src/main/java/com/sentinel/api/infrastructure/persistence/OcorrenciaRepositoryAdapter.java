package com.sentinel.api.infrastructure.persistence;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;
import com.sentinel.api.infrastructure.entity.JpaCameraEntity;
import com.sentinel.api.infrastructure.entity.JpaEstacaoEntity;
import com.sentinel.api.infrastructure.entity.JpaOcorrenciaEntity;
import com.sentinel.api.infrastructure.entity.JpaRelatorioEntity;
import com.sentinel.api.infrastructure.repository.JpaEstacaoRepository;
import com.sentinel.api.infrastructure.repository.JpaCameraRepository;
import com.sentinel.api.infrastructure.repository.JpaOcorrenciaRepository;
import com.sentinel.api.infrastructure.repository.JpaRelatorioRepository;
import com.sentinel.api.interfaces.mapper.OcorrenciaMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class OcorrenciaRepositoryAdapter implements OcorrenciaRepository {

    private final JpaOcorrenciaRepository jpaOcorrenciaRepository;
    private final JpaEstacaoRepository jpaEstacaoRepository;
    private final JpaCameraRepository jpaCameraRepository;
    private final JpaRelatorioRepository jpaRelatorioRepository;

    public OcorrenciaRepositoryAdapter(JpaOcorrenciaRepository jpaOcorrenciaRepository, JpaEstacaoRepository jpaEstacaoRepository, JpaCameraRepository jpaCameraRepository, JpaRelatorioRepository jpaRelatorioRepository) {
        this.jpaOcorrenciaRepository = jpaOcorrenciaRepository;
        this.jpaEstacaoRepository = jpaEstacaoRepository;
        this.jpaCameraRepository = jpaCameraRepository;
        this.jpaRelatorioRepository = jpaRelatorioRepository;
    }

    public Ocorrencia save(Ocorrencia ocorrencia) {
        JpaEstacaoEntity estacao = jpaEstacaoRepository.getReferenceById(ocorrencia.getIdEstacao());
        JpaCameraEntity camera = jpaCameraRepository.getReferenceById(ocorrencia.getIdCamera());
        JpaOcorrenciaEntity entity = OcorrenciaMapper.domainToJpa(ocorrencia, estacao, camera);
        JpaOcorrenciaEntity savedEntity = jpaOcorrenciaRepository.save(entity);
        return OcorrenciaMapper.jpaEntityToDomain(savedEntity);
    }

    public Ocorrencia findById(Long id) {
        JpaOcorrenciaEntity entity = jpaOcorrenciaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ocorrência não encontrada"));
        return OcorrenciaMapper.jpaEntityToDomain(entity);
    }

    public Page<Ocorrencia> findAllByAtivoTrue(Pageable pageable) {
        Page<JpaOcorrenciaEntity> entityPage = jpaOcorrenciaRepository.findAllByAtivoTrue(pageable);
        return entityPage.map(OcorrenciaMapper::jpaEntityToDomain);
    }

    public void delete(Long id) {
        JpaOcorrenciaEntity jpaOcorrenciaEntity = jpaOcorrenciaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ocorrência não encontrada"));
        jpaOcorrenciaRepository.delete(jpaOcorrenciaEntity);
    }

    public Page<Ocorrencia> findByDataBetweenAndTipoOcorrenciaOptional(Long id, Pageable pageable) {

        JpaRelatorioEntity relatorio = jpaRelatorioRepository.getReferenceById(id);
        Page<JpaOcorrenciaEntity> entityPage = jpaOcorrenciaRepository.findByDataBetweenAndTipoOcorrenciaOptional(
                relatorio.getDataInicio(),
                relatorio.getDataFim(),
                relatorio.getTipoOcorrencia(),
                pageable
        );

        return entityPage.map(OcorrenciaMapper::jpaEntityToDomain);
    }


    public Page<Ocorrencia> findAllByAtivoFalse(Pageable pageable) {
        Page<JpaOcorrenciaEntity> entityPage = jpaOcorrenciaRepository.findAllByAtivoFalse(pageable);
        return entityPage.map(OcorrenciaMapper::jpaEntityToDomain);
    }

    public void ativar(Long id) {
        JpaOcorrenciaEntity jpaOcorrenciaEntity =  jpaOcorrenciaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ocorrência não encontrada"));
        jpaOcorrenciaEntity.setAtivo(true);
        jpaOcorrenciaRepository.save(jpaOcorrenciaEntity);
    }
}
