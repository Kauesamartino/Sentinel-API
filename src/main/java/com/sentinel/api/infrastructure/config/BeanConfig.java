package com.sentinel.api.infrastructure.config;

import com.sentinel.api.application.service.CentroControleOperacoesService;
import com.sentinel.api.application.usecase.cco.CreateCcoUseCaseImpl;
import com.sentinel.api.domain.repository.CentroControleOperacoesRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CentroControleOperacoesService centroControleOperacoesService(CentroControleOperacoesRepository centroControleOperacoesRepository) {
        return new CentroControleOperacoesService(centroControleOperacoesRepository);
    }

    @Bean
    public CreateCcoUseCaseImpl createCcoUseCaseImpl(CentroControleOperacoesService centroControleOperacoesService) {
        return new CreateCcoUseCaseImpl(centroControleOperacoesService);
    }


}
