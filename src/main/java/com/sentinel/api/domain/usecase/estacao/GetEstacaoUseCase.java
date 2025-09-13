package com.sentinel.api.domain.usecase.estacao;

import com.sentinel.api.domain.model.Estacao;

public interface GetEstacaoUseCase {
    Estacao execute(Long id);
}
