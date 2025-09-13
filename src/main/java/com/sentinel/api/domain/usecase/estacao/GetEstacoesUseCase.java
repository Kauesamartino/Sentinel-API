package com.sentinel.api.domain.usecase.estacao;

import com.sentinel.api.domain.model.Estacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetEstacoesUseCase {
    Page<Estacao> execute(Pageable pageable);
}
