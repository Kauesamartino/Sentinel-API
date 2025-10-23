package com.sentinel.api.application.usecase.cco;

import com.sentinel.api.domain.model.CentroControleOperacoes;

public interface CreateCcoUseCase {
    CentroControleOperacoes execute(CentroControleOperacoes centroControleOperacoes);
}
