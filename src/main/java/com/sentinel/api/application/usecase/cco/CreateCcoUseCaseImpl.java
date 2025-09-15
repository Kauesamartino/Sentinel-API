package com.sentinel.api.application.usecase.cco;

import com.sentinel.api.application.service.CentroControleOperacoesService;
import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.domain.usecase.cco.CreateCcoUseCase;

public class CreateCcoUseCaseImpl implements CreateCcoUseCase {

    private final CentroControleOperacoesService centroControleOperacoesService;

    public CreateCcoUseCaseImpl(CentroControleOperacoesService centroControleOperacoesService) {
        this.centroControleOperacoesService = centroControleOperacoesService;
    }

    public CentroControleOperacoes execute(CentroControleOperacoes centroControleOperacoes) {
        centroControleOperacoesService.validate(centroControleOperacoes);
        return centroControleOperacoesService.save(centroControleOperacoes);
    }
}
