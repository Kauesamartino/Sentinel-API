package com.sentinel.api.application.usecases.ocorrencia;

import com.sentinel.api.domain.entity.Ocorrencia;
import com.sentinel.api.infrastructure.repository.OcorrenciaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteOcorrenciaUseCase {

    private final OcorrenciaRepository ocorrenciaRepository;

    @Transactional
    public void execute(Long id) {
        Ocorrencia ocorrencia = ocorrenciaRepository.findById(id).orElseThrow();
        ocorrenciaRepository.delete(ocorrencia);
    }
}
