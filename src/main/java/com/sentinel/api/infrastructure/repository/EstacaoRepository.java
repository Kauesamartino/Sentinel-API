package com.sentinel.api.infrastructure.repository;

import com.sentinel.api.infrastructure.entity.JpaEstacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacaoRepository extends JpaRepository<JpaEstacaoEntity, Long> {
}
