package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;

import java.util.List;

public final class GetOcorrenciasDashboardHoraUseCaseImpl implements GetOcorrenciasDashboardHoraUseCase {

    private final OcorrenciaRepository ocorrenciaRepository;

    public GetOcorrenciasDashboardHoraUseCaseImpl(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    @Override
    public List<Ocorrencia> execute() {
        return ocorrenciaRepository.findAllOneHourAgo();
    }
}
