package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;

public interface UpdateOcorrenciaUseCase {
    Ocorrencia execute(Long id, Ocorrencia ocorrenciaAtualizada);
}
