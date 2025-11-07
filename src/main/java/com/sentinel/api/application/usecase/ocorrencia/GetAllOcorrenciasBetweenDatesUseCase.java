package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;

import java.time.LocalDateTime;
import java.util.List;

public interface GetAllOcorrenciasBetweenDatesUseCase {
    List<Ocorrencia> execute(LocalDateTime endDate, LocalDateTime startDate);
}
