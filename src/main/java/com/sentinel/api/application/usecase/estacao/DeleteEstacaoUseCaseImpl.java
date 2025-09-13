package com.sentinel.api.application.usecase.estacao;

import com.sentinel.api.domain.repository.EstacaoRepository;
import com.sentinel.api.domain.usecase.ocorrencia.DeleteOcorrenciaUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteEstacaoUseCaseImpl implements DeleteOcorrenciaUseCase {

    private final EstacaoRepository repository;

    @Transactional
    public void execute(Long id){
        repository.delete(id);
    }

}
