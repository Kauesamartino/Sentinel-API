package com.sentinel.api.infrastructure.config;

import com.sentinel.api.domain.repository.CentroControleOperacoesRepository;
import com.sentinel.api.domain.repository.EstacaoRepository;
import com.sentinel.api.domain.repository.OcorrenciaRepository;
import com.sentinel.api.domain.repository.RelatorioRepository;
import com.sentinel.api.infrastructure.persistence.CentroControleOperacoesRepositoryAdapter;
import com.sentinel.api.infrastructure.persistence.EstacaoRepositoryAdapter;
import com.sentinel.api.infrastructure.persistence.OcorrenciaRepositoryAdapter;
import com.sentinel.api.infrastructure.persistence.RelatorioRepositoryAdapter;
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
}
