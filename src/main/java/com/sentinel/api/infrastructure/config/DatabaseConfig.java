package com.sentinel.api.infrastructure.config;

import com.sentinel.api.domain.repository.*;
import com.sentinel.api.infrastructure.persistence.*;
import com.sentinel.api.infrastructure.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Bean
    public OcorrenciaRepository ocorrenciaRepository(JpaOcorrenciaRepository jpaOcorrenciaRepository, JpaEstacaoRepository jpaEstacaoRepository, JpaCameraRepository jpaCameraRepository, JpaRelatorioRepository jpaRelatorioRepository) {
        return new OcorrenciaRepositoryAdapter(jpaOcorrenciaRepository, jpaEstacaoRepository, jpaCameraRepository, jpaRelatorioRepository);
    }

    @Bean
    public RelatorioRepository relatorioRepository(JpaRelatorioRepository jpaRelatorioRepository) {
        return new RelatorioRepositoryAdapter(jpaRelatorioRepository);
    }

    @Bean
    public CentroControleOperacoesRepository centroControleOperacoesRepository (JpaCentroControleOperacoesRepository jpaCentroControleOperacoesRepository) {
        return new CentroControleOperacoesRepositoryAdapter(jpaCentroControleOperacoesRepository);
    }

    @Bean
    public EstacaoRepository estacaoRepository(JpaEstacaoRepository jpaEstacaoRepository, JpaCentroControleOperacoesRepository jpaCentroControleOperacoesRepository) {
        return new EstacaoRepositoryAdapter(jpaEstacaoRepository, jpaCentroControleOperacoesRepository);
    }

    @Bean
    public CameraRepository cameraRepository(JpaCameraRepository jpaCameraRepository) {
        return new CameraRepositoryAdapter(jpaCameraRepository);
    }
}
