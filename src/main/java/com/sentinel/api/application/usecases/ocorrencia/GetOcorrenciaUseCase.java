package com.sentinel.api.application.usecases.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.infrastructure.entity.JpaOcorrenciaEntity;
import com.sentinel.api.infrastructure.repository.JpaOcorrenciaRepository;
import com.sentinel.api.interfaces.mapper.OcorrenciaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetOcorrenciaUseCase {

    private final JpaOcorrenciaRepository jpaOcorrenciaRepository;
    private final OcorrenciaMapper mapper;

    public Ocorrencia execute(Long id) {
        JpaOcorrenciaEntity jpaOcorrenciaEntity = jpaOcorrenciaRepository.findById(id).orElseThrow();
        return mapper.jpaEntityToDomain(jpaOcorrenciaEntity);
    }

}
