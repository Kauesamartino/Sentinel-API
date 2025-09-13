package com.sentinel.api.domain.usecase.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;

public interface GetOcorrenciaUseCase {
    Ocorrencia execute(Long id);
}
