package com.sentinel.api.application.usecase.estacao;

import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.repository.EstacaoRepository;
import com.sentinel.api.domain.usecase.estacao.GetEstacaoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetEstacaoUseCaseImpl implements GetEstacaoUseCase {

    private final EstacaoRepository repository;

    public Estacao execute(Long id) {
        return repository.findById(id);
    }
}
