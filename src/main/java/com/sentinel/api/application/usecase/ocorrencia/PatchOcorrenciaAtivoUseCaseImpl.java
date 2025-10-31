package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.domain.repository.OcorrenciaRepository;

public final class PatchOcorrenciaAtivoUseCaseImpl implements PatchOcorrenciaAtivoUseCase {

    private final OcorrenciaRepository ocorrenciaRepository;

    public PatchOcorrenciaAtivoUseCaseImpl(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    public void execute(Long id) {
        ocorrenciaRepository.ativar(id);
    }
}
