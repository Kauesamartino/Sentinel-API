package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;

import java.time.LocalDateTime;
import java.util.List;

public final class GetAllOcorrenciasBetweenDatesUseCaseImpl implements  GetAllOcorrenciasBetweenDatesUseCase {

    private final OcorrenciaRepository ocorrenciaRepository;

    public GetAllOcorrenciasBetweenDatesUseCaseImpl(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }


    @Override
    public List<Ocorrencia> execute(LocalDateTime endDate, LocalDateTime startDate) {
        return ocorrenciaRepository.findAllByDataBetween(endDate, startDate);
    }
}
