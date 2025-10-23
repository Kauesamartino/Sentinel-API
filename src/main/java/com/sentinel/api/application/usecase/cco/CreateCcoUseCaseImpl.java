package com.sentinel.api.application.usecase.cco;

import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.domain.repository.CentroControleOperacoesRepository;

public final class CreateCcoUseCaseImpl implements CreateCcoUseCase {

    private final CentroControleOperacoesRepository centroControleOperacoesRepository;

    public CreateCcoUseCaseImpl(CentroControleOperacoesRepository centroControleOperacoesRepository) {
        this.centroControleOperacoesRepository = centroControleOperacoesRepository;
    }

    public CentroControleOperacoes execute(CentroControleOperacoes centroControleOperacoes) {
        return centroControleOperacoesRepository.save(centroControleOperacoes);
    }
}
