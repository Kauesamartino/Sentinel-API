package com.sentinel.api.application.usecases.ocorrencia;

import com.sentinel.api.application.usecases.ocorrencia.ports.CreateOcorrenciaInput;
import com.sentinel.api.infrastructure.entity.JpaEstacaoEntity;
import com.sentinel.api.infrastructure.entity.JpaOcorrenciaEntity;
import com.sentinel.api.infrastructure.repository.EstacaoRepository;
import com.sentinel.api.infrastructure.repository.OcorrenciaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateOcorrenciaUseCase {

    private final OcorrenciaRepository ocorrenciaRepository;
    private final EstacaoRepository estacaoRepository;

    @Transactional
    public JpaOcorrenciaEntity execute(CreateOcorrenciaInput input){
        JpaEstacaoEntity jpaEstacaoEntity = estacaoRepository.getReferenceById(input.idEstacao());
        JpaOcorrenciaEntity jpaOcorrenciaEntity = new JpaOcorrenciaEntity(input, jpaEstacaoEntity);
        return ocorrenciaRepository.save(jpaOcorrenciaEntity);
    }

}
