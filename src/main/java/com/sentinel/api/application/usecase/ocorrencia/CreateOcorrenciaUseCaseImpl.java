package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;

public final class CreateOcorrenciaUseCaseImpl implements CreateOcorrenciaUseCase {

    private final OcorrenciaRepository ocorrenciaRepository;

    public CreateOcorrenciaUseCaseImpl(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    public Ocorrencia execute(Ocorrencia ocorrencia){
        return ocorrenciaRepository.save(ocorrencia);
    }

}
