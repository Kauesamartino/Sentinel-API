package com.sentinel.api.infrastructure.config;

import com.sentinel.api.application.usecase.ocorrencia.*;
import com.sentinel.api.domain.repository.OcorrenciaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OcorrenciaUseCaseConfig {

    private final OcorrenciaRepository ocorrenciaRepository;

    public OcorrenciaUseCaseConfig(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    @Bean
    public CreateOcorrenciaUseCase createOcorrenciaUseCase() {
        return new CreateOcorrenciaUseCaseImpl(ocorrenciaRepository);
    }

    @Bean
    public DeleteOcorrenciaUseCase deleteOcorrenciaUseCaseImpl() {
        return new DeleteOcorrenciaUseCaseImpl(ocorrenciaRepository);
    }

    @Bean
    public GetOcorrenciasAtivoFalseUseCase getOcorrenciasAtivoFalseUseCaseImpl() {
        return new GetOcorrenciasAtivoFalseUseCaseImpl(ocorrenciaRepository);
    }

    @Bean
    public GetOcorrenciasRelatorioUseCase updateOcorrenciaUseCaseImpl() {
        return new GetOcorrenciasRelatorioUseCaseImpl(ocorrenciaRepository);
    }

    @Bean
    public GetOcorrenciasUseCase getOcorrenciasUseCaseImpl() {
        return new GetOcorrenciasUseCaseImpl(ocorrenciaRepository);
    }

    @Bean
    public GetOcorrenciaUseCase getOcorrenciaUseCaseImpl() {
        return new GetOcorrenciaUseCaseImpl(ocorrenciaRepository);
    }

    @Bean
    public PatchOcorrenciaAtivoUseCase patchOcorrenciaAtivoUseCaseImpl() {
        return new PatchOcorrenciaAtivoUseCaseImpl(ocorrenciaRepository);
    }

    @Bean
    public UpdateOcorrenciaUseCase updateOcorrenciaUseCase() {
        return new UpdateOcorrenciaUseCaseImpl(ocorrenciaRepository);
    }

    @Bean
    public GetOcorrenciasDashboardHoraUseCase getOcorrenciasDashboardHoraUseCase() {
        return new GetOcorrenciasDashboardHoraUseCaseImpl(ocorrenciaRepository);
    }

    @Bean
    public GetAllOcorrenciasDashboardUseCase getAllOcorrenciasDashboardUseCaseImpl() {
        return new GetAllOcorrenciasDashboardUseCaseImpl(ocorrenciaRepository);
    }

    @Bean
    public GetAllOcorrenciasBetweenDatesUseCase getAllOcorrenciasBetweenDatesUseCaseImpl() {
        return new GetAllOcorrenciasBetweenDatesUseCaseImpl(ocorrenciaRepository);
    }
}
