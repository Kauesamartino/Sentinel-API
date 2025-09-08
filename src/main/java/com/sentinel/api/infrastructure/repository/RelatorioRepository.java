package com.sentinel.api.infrastructure.repository;

import com.sentinel.api.infrastructure.entity.JpaRelatorioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelatorioRepository extends JpaRepository<JpaRelatorioEntity, Long> {
}
