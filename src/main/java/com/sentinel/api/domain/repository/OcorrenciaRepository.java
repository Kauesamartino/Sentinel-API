package com.sentinel.api.domain.repository;

import com.sentinel.api.domain.model.Ocorrencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface OcorrenciaRepository {
    Ocorrencia save(Ocorrencia ocorrencia);
    Ocorrencia findById(Long id);
    Page<Ocorrencia> findAllByAtivoTrue(Pageable pageable);

    void delete(Long id);

    Page<Ocorrencia> findByDataBetweenAndTipoOcorrenciaOptional(Long id, Pageable pageable);

    Page<Ocorrencia> findAllByAtivoFalse(Pageable pageable);

    void ativar(Long id);

    List<Ocorrencia> findAllOneHourAgo();

    List<Ocorrencia> findAll();

    List<Ocorrencia> findAllByDataBetween(LocalDateTime endDate, LocalDateTime startDate);
}
