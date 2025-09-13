package com.sentinel.api.application.usecases.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;
import com.sentinel.api.domain.usecase.ocorrencia.GetOcorrenciasRelatorioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetOcorrenciasRelatorioUseCaseImpl implements GetOcorrenciasRelatorioUseCase {

    private final OcorrenciaRepository repository;

    public Page<Ocorrencia> execute(Long id, Pageable pageable) {
        return repository.findByDataBetweenAndTipoOcorrenciaOptional(id, pageable);
    }
}
