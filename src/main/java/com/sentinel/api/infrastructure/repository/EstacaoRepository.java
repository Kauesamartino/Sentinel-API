package com.sentinel.api.infrastructure.repository;

import com.sentinel.api.domain.entity.Estacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacaoRepository extends JpaRepository<Estacao, Long> {
}
