package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;
import com.sentinel.api.domain.usecase.ocorrencia.GetOcorrenciaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetOcorrenciaUseCaseImpl implements GetOcorrenciaUseCase {

    private final OcorrenciaRepository repository;

    public Ocorrencia execute(Long id) {
        return repository.findById(id);
    }

}
