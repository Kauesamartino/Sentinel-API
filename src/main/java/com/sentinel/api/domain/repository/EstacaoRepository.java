package com.sentinel.api.domain.repository;

import com.sentinel.api.domain.model.Estacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EstacaoRepository {
    Estacao save(Estacao estacao);
    Estacao findById(Long idEstacao);

    Page<Estacao> findAll(Pageable pageable);
}
