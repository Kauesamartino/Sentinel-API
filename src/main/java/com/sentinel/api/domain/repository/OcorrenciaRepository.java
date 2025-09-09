package com.sentinel.api.domain.repository;

import com.sentinel.api.domain.model.Ocorrencia;

public interface OcorrenciaRepository {
    Ocorrencia save(Ocorrencia ocorrencia);
    Ocorrencia findById(Long id);
}
