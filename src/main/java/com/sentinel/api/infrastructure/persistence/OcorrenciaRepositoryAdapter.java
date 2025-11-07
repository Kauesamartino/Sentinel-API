package com.sentinel.api.infrastructure.persistence;

import com.sentinel.api.domain.logging.Logger;
import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;
import com.sentinel.api.infrastructure.entity.JpaCameraEntity;
import com.sentinel.api.infrastructure.entity.JpaEstacaoEntity;
import com.sentinel.api.infrastructure.entity.JpaOcorrenciaEntity;
import com.sentinel.api.infrastructure.entity.JpaRelatorioEntity;
import com.sentinel.api.infrastructure.exception.InfraestruturaException;
import com.sentinel.api.infrastructure.repository.JpaEstacaoRepository;
import com.sentinel.api.infrastructure.repository.JpaCameraRepository;
import com.sentinel.api.infrastructure.repository.JpaOcorrenciaRepository;
import com.sentinel.api.infrastructure.repository.JpaRelatorioRepository;
import com.sentinel.api.interfaces.mapper.OcorrenciaMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class OcorrenciaRepositoryAdapter implements OcorrenciaRepository {

    private final JpaOcorrenciaRepository jpaOcorrenciaRepository;
    private final JpaEstacaoRepository jpaEstacaoRepository;
    private final JpaCameraRepository jpaCameraRepository;
    private final JpaRelatorioRepository jpaRelatorioRepository;
    private final Logger logger;

    public OcorrenciaRepositoryAdapter(JpaOcorrenciaRepository jpaOcorrenciaRepository, JpaEstacaoRepository jpaEstacaoRepository, JpaCameraRepository jpaCameraRepository, JpaRelatorioRepository jpaRelatorioRepository, Logger logger) {
        this.jpaOcorrenciaRepository = jpaOcorrenciaRepository;
        this.jpaEstacaoRepository = jpaEstacaoRepository;
        this.jpaCameraRepository = jpaCameraRepository;
        this.jpaRelatorioRepository = jpaRelatorioRepository;
        this.logger = logger;
    }

    public Ocorrencia save(Ocorrencia ocorrencia) {
        logger.info("Salvando ocorrência: " + ocorrencia.getId() + ", " + ocorrencia.getTitulo());

        JpaEstacaoEntity estacao = jpaEstacaoRepository.getReferenceById(ocorrencia.getIdEstacao());

        JpaCameraEntity camera = null;
        if (ocorrencia.getIdCamera() != null) {
            logger.info("Ocorrência possui câmera associada: " + ocorrencia.getIdCamera());
            camera = jpaCameraRepository.getReferenceById(ocorrencia.getIdCamera());
        } else {
            logger.info("Ocorrência não possui câmera associada.");
        }

        JpaOcorrenciaEntity entity = OcorrenciaMapper.domainToJpa(ocorrencia, estacao, camera);

        try{
            JpaOcorrenciaEntity savedEntity = jpaOcorrenciaRepository.save(entity);
            return OcorrenciaMapper.jpaEntityToDomain(savedEntity);

        } catch (DataAccessException ex){
            logger.error("Erro ao salvar ocorrência: " + ex.getMessage(), ex);
            throw new InfraestruturaException("Erro ao salvar ocorrência", ex);
        }
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
        logger.info("Deletando ocorrência com ID: " + id);
        try {
            JpaOcorrenciaEntity jpaOcorrenciaEntity = jpaOcorrenciaRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Ocorrência não encontrada"));
            jpaOcorrenciaRepository.delete(jpaOcorrenciaEntity);
            logger.info("Ocorrência deletada com sucesso");
        } catch (DataAccessException ex){
            logger.error("Erro ao deletar ocorrência: " + ex.getMessage(), ex);
            throw new InfraestruturaException("Erro ao deletar ocorrência", ex);
        }

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

    @Override
    public List<Ocorrencia> findAllOneHourAgo() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dataInicio = now.minusHours(1);
        List<JpaOcorrenciaEntity> entities = jpaOcorrenciaRepository.findAll();
        return entities.stream()
                .filter(entity -> entity.getData().isAfter(dataInicio))
                .map(OcorrenciaMapper::jpaEntityToDomain)
                .toList();
    }

    @Override
    public List<Ocorrencia> findAll() {

        List<JpaOcorrenciaEntity> entities = jpaOcorrenciaRepository.findAll();
        return entities.stream()
                .map(OcorrenciaMapper::jpaEntityToDomain)
                .toList();
    }

    @Override
    public List<Ocorrencia> findAllByDataBetween(LocalDateTime endDate, LocalDateTime startDate) {
        List<JpaOcorrenciaEntity> entities = jpaOcorrenciaRepository.findAllByDataBetween(endDate, startDate);
        return entities.stream()
                .map(OcorrenciaMapper::jpaEntityToDomain)
                .toList();
    }
}
