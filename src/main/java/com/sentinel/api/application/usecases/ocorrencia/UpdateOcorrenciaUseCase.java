package com.sentinel.api.application.usecases.ocorrencia;

import com.sentinel.api.application.usecases.ocorrencia.ports.UpdateOcorrenciaInput;
import com.sentinel.api.domain.entity.Ocorrencia;
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
    public Ocorrencia execute(Long id, UpdateOcorrenciaInput input) {
        Ocorrencia ocorrencia = repository.findById(id).orElseThrow();

        ocorrencia.setTitulo(input.titulo());
        ocorrencia.setDescricao(input.description());
        ocorrencia.setStatus(input.status());
        ocorrencia.setTipoOcorrencia(input.tipoOcorrencia());

        return repository.save(ocorrencia);
    }
}
