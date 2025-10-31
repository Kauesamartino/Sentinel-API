package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;

public final class GetOcorrenciaUseCaseImpl implements GetOcorrenciaUseCase {

    private final OcorrenciaRepository repository;

    public GetOcorrenciaUseCaseImpl(OcorrenciaRepository repository) {
        this.repository = repository;
    }

    public Ocorrencia execute(Long id) {
        return repository.findById(id);
    }
}
