package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public final class GetOcorrenciasUseCaseImpl implements GetOcorrenciasUseCase {

    private final OcorrenciaRepository ocorrenciaRepository;

    public GetOcorrenciasUseCaseImpl(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    public Page<Ocorrencia> execute(Pageable pageable) {
        return ocorrenciaRepository.findAllByAtivoTrue(pageable);
    }
}
