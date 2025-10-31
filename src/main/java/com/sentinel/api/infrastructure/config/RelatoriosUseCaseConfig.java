package com.sentinel.api.infrastructure.config;

import com.sentinel.api.application.usecase.relatorio.CreateRelatorioUseCase;
import com.sentinel.api.application.usecase.relatorio.CreateRelatorioUseCaseImpl;
import com.sentinel.api.application.usecase.relatorio.GetRelatoriosUseCase;
import com.sentinel.api.application.usecase.relatorio.GetRelatoriosUseCaseImpl;
import com.sentinel.api.domain.repository.RelatorioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RelatoriosUseCaseConfig {

    private final RelatorioRepository relatorioRepository;

    public RelatoriosUseCaseConfig(RelatorioRepository relatorioRepository) {
        this.relatorioRepository = relatorioRepository;
    }

    @Bean
    public CreateRelatorioUseCase createRelatorioUseCaseImpl() {
        return new CreateRelatorioUseCaseImpl(relatorioRepository);
    }

    @Bean
    public GetRelatoriosUseCase getRelatoriosUseCaseImpl() {
        return new GetRelatoriosUseCaseImpl(relatorioRepository);
    }
}
