package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public final class GetOcorrenciasRelatorioUseCaseImpl implements GetOcorrenciasRelatorioUseCase {

    private final OcorrenciaRepository repository;

    public GetOcorrenciasRelatorioUseCaseImpl(OcorrenciaRepository repository) {
        this.repository = repository;
    }

    public Page<Ocorrencia> execute(Long id, Pageable pageable) {
        return repository.findByDataBetweenAndTipoOcorrenciaOptional(id, pageable);
    }
}
