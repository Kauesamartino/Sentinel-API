package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetOcorrenciasRelatorioUseCase {
    Page<Ocorrencia> execute(Long id, Pageable pageable);
}
