package com.sentinel.api.application.usecases.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetOcorrenciaUseCaseImpl {

    private final OcorrenciaRepository repository;

    public Ocorrencia execute(Long id) {
        return repository.findById(id);
    }

}
