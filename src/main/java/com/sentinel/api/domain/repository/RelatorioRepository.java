package com.sentinel.api.domain.repository;

import com.sentinel.api.domain.model.Relatorio;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioRepository {
    Relatorio save(Relatorio relatorio);
}
