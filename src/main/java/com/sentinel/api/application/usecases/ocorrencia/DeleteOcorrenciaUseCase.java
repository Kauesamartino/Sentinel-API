package com.sentinel.api.application.usecases.ocorrencia;

import com.sentinel.api.infrastructure.entity.JpaOcorrenciaEntity;
import com.sentinel.api.infrastructure.repository.JpaOcorrenciaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteOcorrenciaUseCase {

    private final JpaOcorrenciaRepository jpaOcorrenciaRepository;

    @Transactional
    public void execute(Long id) {
        JpaOcorrenciaEntity jpaOcorrenciaEntity = jpaOcorrenciaRepository.findById(id).orElseThrow();
        jpaOcorrenciaRepository.delete(jpaOcorrenciaEntity);
    }
}
