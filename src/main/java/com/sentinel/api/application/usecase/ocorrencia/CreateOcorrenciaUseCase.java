package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;

public interface CreateOcorrenciaUseCase {
    Ocorrencia execute(Ocorrencia ocorrencia);
}
