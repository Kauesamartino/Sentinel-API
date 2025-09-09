package com.sentinel.api.domain.repository;

import com.sentinel.api.domain.model.Relatorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RelatorioRepository {
    Relatorio save(Relatorio relatorio);

    Page<Relatorio> findAll(Pageable pageable);
}
