package com.sentinel.api.application.usecases.ocorrencia;

import com.sentinel.api.domain.entity.Estacao;
import com.sentinel.api.domain.entity.Ocorrencia;
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
    public Ocorrencia execute(CreateOcorrenciaInput input){
        Estacao estacao = estacaoRepository.getReferenceById(input.idEstacao());
        Ocorrencia ocorrencia = new Ocorrencia(input, estacao);
        return ocorrenciaRepository.save(ocorrencia);
    }

}
