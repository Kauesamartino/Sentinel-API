package com.sentinel.api.infrastructure.repository;

import com.sentinel.api.infrastructure.entity.JpaCameraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCameraRepository extends JpaRepository<JpaCameraEntity, Long> {
}
