package com.sentinel.api.infrastructure.repository;

import com.sentinel.api.infrastructure.entity.JpaCentroControleOperacoesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CentroControleOperacoesRepository extends JpaRepository<JpaCentroControleOperacoesEntity, Long> {
}
