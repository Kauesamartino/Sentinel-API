package com.sentinel.api.domain.usecase.estacao;

import com.sentinel.api.domain.model.Estacao;

public interface CreateEstacaoUseCase {
    Estacao execute(Estacao estacao);
}
