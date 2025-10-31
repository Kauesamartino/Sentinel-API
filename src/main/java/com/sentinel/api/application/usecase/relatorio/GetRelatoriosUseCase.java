package com.sentinel.api.application.usecase.relatorio;

import com.sentinel.api.domain.model.Relatorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetRelatoriosUseCase {
    Page<Relatorio> execute(Pageable pageable);
}
