package com.sentinel.api.infrastructure.config;

import com.sentinel.api.application.usecase.cco.CreateCcoUseCase;
import com.sentinel.api.application.usecase.cco.CreateCcoUseCaseImpl;
import com.sentinel.api.domain.repository.CentroControleOperacoesRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CcoUseCaseConfig {

    private final CentroControleOperacoesRepository centroControleOperacoesRepository;

    public CcoUseCaseConfig(CentroControleOperacoesRepository centroControleOperacoesRepository) {
        this.centroControleOperacoesRepository = centroControleOperacoesRepository;
    }

    @Bean
    public CreateCcoUseCase createCcoUseCase() {
        return new CreateCcoUseCaseImpl(centroControleOperacoesRepository);
    }
}
