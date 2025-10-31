package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.domain.repository.OcorrenciaRepository;

public final class DeleteOcorrenciaUseCaseImpl implements DeleteOcorrenciaUseCase {

    private final OcorrenciaRepository ocorrenciaRepository;

    public DeleteOcorrenciaUseCaseImpl(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    public void execute(Long id) {
        ocorrenciaRepository.delete(id);
    }
}
