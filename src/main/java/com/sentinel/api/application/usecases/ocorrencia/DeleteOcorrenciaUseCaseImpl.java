package com.sentinel.api.application.usecases.ocorrencia;

import com.sentinel.api.domain.repository.OcorrenciaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteOcorrenciaUseCaseImpl {

    private final OcorrenciaRepository ocorrenciaRepository;

    @Transactional
    public void execute(Long id) {
        ocorrenciaRepository.delete(id);
    }
}
