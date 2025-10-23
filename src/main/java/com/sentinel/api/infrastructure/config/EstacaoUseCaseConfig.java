package com.sentinel.api.infrastructure.config;

import com.sentinel.api.application.usecase.estacao.*;
import com.sentinel.api.domain.repository.EstacaoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EstacaoUseCaseConfig {

    private final EstacaoRepository estacaoRepository;

    public EstacaoUseCaseConfig(EstacaoRepository estacaoRepository) {
        this.estacaoRepository = estacaoRepository;
    }

    @Bean
    public CreateEstacaoUseCase createEstacaoUseCaseImpl() {
        return new CreateEstacaoUseCaseImpl(estacaoRepository);
    }

    @Bean
    public DeleteEstacaoUseCase deleteEstacaoUseCaseImpl() {
        return new DeleteEstacaoUseCaseImpl(estacaoRepository);
    }

    @Bean
    public GetEstacaoUseCase getEstacaoUseCaseImpl() {
        return new GetEstacaoUseCaseImpl(estacaoRepository);
    }

    @Bean
    public GetEstacoesUseCase getEstacoesUseCaseImpl() {
        return new GetEstacoesUseCaseImpl(estacaoRepository);
    }
}
