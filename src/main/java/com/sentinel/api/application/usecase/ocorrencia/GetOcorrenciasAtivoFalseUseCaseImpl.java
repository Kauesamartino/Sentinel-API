package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.application.service.OcorrenciaService;
import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.usecase.ocorrencia.GetOcorrenciasAtivoFalseUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class GetOcorrenciasAtivoFalseUseCaseImpl implements GetOcorrenciasAtivoFalseUseCase {

    private final OcorrenciaService ocorrenciaService;

    public GetOcorrenciasAtivoFalseUseCaseImpl(OcorrenciaService ocorrenciaService) {
        this.ocorrenciaService = ocorrenciaService;
    }

    public Page<Ocorrencia> execute(Pageable pageable) {
        return ocorrenciaService.findAllByAtivoFalse(pageable);
    }
}
