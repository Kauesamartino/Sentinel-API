package com.sentinel.api.infrastructure.config;

import com.sentinel.api.application.service.CentroControleOperacoesService;
import com.sentinel.api.application.service.OcorrenciaService;
import com.sentinel.api.application.service.RelatorioService;
import com.sentinel.api.application.usecase.cco.CreateCcoUseCaseImpl;
import com.sentinel.api.application.usecase.ocorrencia.CreateOcorrenciaUseCaseImpl;
import com.sentinel.api.application.usecase.relatorio.CreateRelatorioUseCaseImpl;
import com.sentinel.api.domain.repository.CentroControleOperacoesRepository;
import com.sentinel.api.domain.repository.OcorrenciaRepository;
import com.sentinel.api.domain.repository.RelatorioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {


    // Services
    @Bean
    public CentroControleOperacoesService centroControleOperacoesService(CentroControleOperacoesRepository centroControleOperacoesRepository) {
        return new CentroControleOperacoesService(centroControleOperacoesRepository);
    }

    @Bean
    public OcorrenciaService ocorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
        return new OcorrenciaService(ocorrenciaRepository);
    }

    @Bean
    public RelatorioService relatorioService(RelatorioRepository relatorioRepository) {
        return new RelatorioService(relatorioRepository);
    }

    // Cco usecases
    @Bean
    public CreateCcoUseCaseImpl createCcoUseCaseImpl(CentroControleOperacoesService centroControleOperacoesService) {
        return new CreateCcoUseCaseImpl(centroControleOperacoesService);
    }

    // Ocorrencia usecases
    @Bean
    public CreateOcorrenciaUseCaseImpl createOcorrenciaUseCaseImpl(OcorrenciaService ocorrenciaService) {
        return new CreateOcorrenciaUseCaseImpl(ocorrenciaService);
    }

    // Relatorio usecases
    @Bean
    public CreateRelatorioUseCaseImpl  createRelatorioUseCaseImpl(RelatorioService relatorioService) {
        return new CreateRelatorioUseCaseImpl(relatorioService);
    }

}
