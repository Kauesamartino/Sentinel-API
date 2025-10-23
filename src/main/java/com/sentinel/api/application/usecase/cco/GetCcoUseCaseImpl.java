package com.sentinel.api.application.usecase.cco;

import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.domain.repository.CentroControleOperacoesRepository;

public final class GetCcoUseCaseImpl implements GetCcoUseCase {

    private final CentroControleOperacoesRepository centroControleOperacoesRepository;

    public GetCcoUseCaseImpl(CentroControleOperacoesRepository centroControleOperacoesRepository) {
        this.centroControleOperacoesRepository = centroControleOperacoesRepository;
    }

    @Override
    public CentroControleOperacoes execute(Long id) {
        return centroControleOperacoesRepository.findById(id);
    }
}
