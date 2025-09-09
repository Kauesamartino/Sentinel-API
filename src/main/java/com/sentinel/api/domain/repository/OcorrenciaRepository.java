package com.sentinel.api.domain.repository;

import com.sentinel.api.domain.model.Ocorrencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OcorrenciaRepository {
    Ocorrencia save(Ocorrencia ocorrencia);
    Ocorrencia findById(Long id);
    Page<Ocorrencia> findAllByAtivoTrue(Pageable pageable);

    void delete(Long id);
}
