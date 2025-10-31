package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;

import java.util.List;

public interface GetOcorrenciasDashboardHoraUseCase {
    List<Ocorrencia> execute();
}
