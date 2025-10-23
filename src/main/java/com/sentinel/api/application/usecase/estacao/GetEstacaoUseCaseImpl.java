package com.sentinel.api.application.usecase.estacao;

import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.repository.EstacaoRepository;

public final class GetEstacaoUseCaseImpl implements GetEstacaoUseCase {

    private final EstacaoRepository repository;

    public GetEstacaoUseCaseImpl(EstacaoRepository repository) {
        this.repository = repository;
    }

    public Estacao execute(Long id) {
        return repository.findById(id);
    }
}
