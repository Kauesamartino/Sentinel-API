package com.sentinel.api.domain.repository;

import com.sentinel.api.domain.model.Estacao;

public interface EstacaoRepository {
    Estacao save(Estacao estacao);
    Estacao findById(Long idEstacao);
}
