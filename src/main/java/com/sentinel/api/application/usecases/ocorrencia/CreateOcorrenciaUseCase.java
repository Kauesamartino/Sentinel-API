package com.sentinel.api.application.usecases.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateOcorrenciaUseCase {

    private final OcorrenciaRepository ocorrenciaRepository;

    @Transactional
    public Ocorrencia execute(Ocorrencia ocorrencia){
        if (ocorrencia == null) {
            throw new IllegalArgumentException("Ocorrência não pode ser nula");
        }
        return ocorrenciaRepository.save(ocorrencia);
    }

}
