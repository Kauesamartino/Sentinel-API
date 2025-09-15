package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.application.service.OcorrenciaService;
import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.usecase.ocorrencia.CreateOcorrenciaUseCase;

public class CreateOcorrenciaUseCaseImpl implements CreateOcorrenciaUseCase {

    private final OcorrenciaService ocorrenciaService;

    public CreateOcorrenciaUseCaseImpl(OcorrenciaService ocorrenciaService) {
        this.ocorrenciaService = ocorrenciaService;
    }

    public Ocorrencia execute(Ocorrencia ocorrencia){
        return ocorrenciaService.save(ocorrencia);
    }

}
