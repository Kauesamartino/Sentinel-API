package com.sentinel.api.application.usecases.ocorrencia;

import com.sentinel.api.infrastructure.entity.JpaOcorrenciaEntity;
import com.sentinel.api.infrastructure.repository.OcorrenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetOcorrenciaUseCase {

    private final OcorrenciaRepository ocorrenciaRepository;

    public JpaOcorrenciaEntity execute(Long id) {
        return ocorrenciaRepository.findById(id).orElseThrow();
    }

}
