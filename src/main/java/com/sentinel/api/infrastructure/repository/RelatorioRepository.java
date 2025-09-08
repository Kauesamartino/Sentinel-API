package com.sentinel.api.infrastructure.repository;

import com.sentinel.api.domain.entity.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelatorioRepository extends JpaRepository<Relatorio, Long> {
}
