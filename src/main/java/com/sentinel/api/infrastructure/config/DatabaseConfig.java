package com.sentinel.api.infrastructure.config;

import com.sentinel.api.domain.repository.OcorrenciaRepository;
import com.sentinel.api.domain.repository.RelatorioRepository;
import com.sentinel.api.infrastructure.persistence.OcorrenciaRepositoryAdapter;
import com.sentinel.api.infrastructure.persistence.RelatorioRepositoryAdapter;
import com.sentinel.api.infrastructure.repository.JpaCameraRepository;
import com.sentinel.api.infrastructure.repository.JpaEstacaoRepository;
import com.sentinel.api.infrastructure.repository.JpaOcorrenciaRepository;
import com.sentinel.api.infrastructure.repository.JpaRelatorioRepository;
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
}
