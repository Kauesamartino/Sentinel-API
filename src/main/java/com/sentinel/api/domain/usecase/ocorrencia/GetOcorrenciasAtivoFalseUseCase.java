package com.sentinel.api.domain.usecase.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetOcorrenciasAtivoFalseUseCase {
    Page<Ocorrencia> execute(Pageable  pageable);
}
