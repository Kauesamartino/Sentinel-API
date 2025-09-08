package com.sentinel.api.application.usecases.ocorrencia;

import com.sentinel.api.application.usecases.ocorrencia.ports.UpdateOcorrenciaInput;
import com.sentinel.api.infrastructure.entity.JpaOcorrenciaEntity;
import com.sentinel.api.infrastructure.repository.OcorrenciaRepository;
import com.sentinel.api.interfaces.mapper.OcorrenciaMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateOcorrenciaUseCase {
    private final OcorrenciaRepository repository;
    private final OcorrenciaMapper mapper;

    @Transactional
    public JpaOcorrenciaEntity execute(Long id, UpdateOcorrenciaInput input) {
        JpaOcorrenciaEntity jpaOcorrenciaEntity = repository.findById(id).orElseThrow();

        jpaOcorrenciaEntity.setTitulo(input.titulo());
        jpaOcorrenciaEntity.setDescricao(input.description());
        jpaOcorrenciaEntity.setStatus(input.status());
        jpaOcorrenciaEntity.setTipoOcorrencia(input.tipoOcorrencia());

        return repository.save(jpaOcorrenciaEntity);
    }
}
