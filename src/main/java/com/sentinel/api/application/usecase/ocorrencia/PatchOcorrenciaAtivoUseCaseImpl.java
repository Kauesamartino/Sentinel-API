package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.application.service.OcorrenciaService;
import com.sentinel.api.domain.usecase.ocorrencia.PatchOcorrenciaAtivoUseCase;

public class PatchOcorrenciaAtivoUseCaseImpl implements PatchOcorrenciaAtivoUseCase {

    private final OcorrenciaService ocorrenciaService;

    public PatchOcorrenciaAtivoUseCaseImpl(OcorrenciaService ocorrenciaService) {
        this.ocorrenciaService = ocorrenciaService;
    }

    public void execute(Long id) {
        ocorrenciaService.ativar(id);
    }
}
