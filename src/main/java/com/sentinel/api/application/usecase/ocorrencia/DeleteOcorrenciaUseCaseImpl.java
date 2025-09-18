package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.application.service.OcorrenciaService;
import com.sentinel.api.domain.usecase.ocorrencia.DeleteOcorrenciaUseCase;

public class DeleteOcorrenciaUseCaseImpl implements DeleteOcorrenciaUseCase {

    private final OcorrenciaService ocorrenciaService;

    public DeleteOcorrenciaUseCaseImpl(OcorrenciaService ocorrenciaService) {
        this.ocorrenciaService = ocorrenciaService;
    }

    public void execute(Long id) {
        ocorrenciaService.delete(id);
    }
}
