package com.sentinel.api.application.usecases.ocorrencia;

import com.sentinel.api.domain.repository.OcorrenciaRepository;
import com.sentinel.api.infrastructure.entity.JpaOcorrenciaEntity;
import com.sentinel.api.infrastructure.repository.JpaOcorrenciaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteOcorrenciaUseCase {

    private final OcorrenciaRepository ocorrenciaRepository;

    @Transactional
    public void execute(Long id) {
        ocorrenciaRepository.delete(id);
    }
}
