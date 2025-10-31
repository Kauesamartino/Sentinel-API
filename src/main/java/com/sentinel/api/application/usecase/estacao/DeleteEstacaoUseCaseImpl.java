package com.sentinel.api.application.usecase.estacao;

import com.sentinel.api.domain.repository.EstacaoRepository;

public final class DeleteEstacaoUseCaseImpl implements DeleteEstacaoUseCase {

    private final EstacaoRepository estacaoRepository;

    public DeleteEstacaoUseCaseImpl(EstacaoRepository repository) {
        this.estacaoRepository = repository;
    }

    public void execute(Long id){
        estacaoRepository.delete(id);
    }

}
