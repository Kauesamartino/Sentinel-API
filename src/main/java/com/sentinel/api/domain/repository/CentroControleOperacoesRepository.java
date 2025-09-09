package com.sentinel.api.domain.repository;

import com.sentinel.api.domain.model.CentroControleOperacoes;

public interface CentroControleOperacoesRepository {
    CentroControleOperacoes save(CentroControleOperacoes centroControleOperacoes);
    CentroControleOperacoes findById(Long idCco);
}
