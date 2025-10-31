package com.sentinel.api.application.usecase.relatorio;

import com.sentinel.api.domain.model.Relatorio;

public interface CreateRelatorioUseCase {
    Relatorio execute(Relatorio relatorio);
}
