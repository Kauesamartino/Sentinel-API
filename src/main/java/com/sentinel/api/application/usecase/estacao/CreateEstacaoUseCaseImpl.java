package com.sentinel.api.application.usecase.estacao;

import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.repository.EstacaoRepository;

public final class CreateEstacaoUseCaseImpl implements CreateEstacaoUseCase {

    private final EstacaoRepository estacaoRepository;

    public CreateEstacaoUseCaseImpl(EstacaoRepository estacaoRepository) {
        this.estacaoRepository = estacaoRepository;
    }

    public Estacao execute(Estacao estacao) {
        if (estacao == null) {
            throw new IllegalArgumentException("Estação não pode ser nula");
        }
        return estacaoRepository.save(estacao);
    }
}
