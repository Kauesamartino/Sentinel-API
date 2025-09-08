package com.sentinel.api.infrastructure.repository;

import com.sentinel.api.infrastructure.entity.JpaOcorrenciaEntity;
import com.sentinel.api.domain.enums.TipoOcorrencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface OcorrenciaRepository extends JpaRepository<JpaOcorrenciaEntity, Long> {
    Page<JpaOcorrenciaEntity> findAllByAtivoTrue(Pageable pageable);

    @Query("""
        SELECT o FROM Ocorrencia o
        WHERE o.ativo = true
          AND o.data BETWEEN :inicio AND :fim
          AND (:tipoOcorrencia IS NULL OR o.tipoOcorrencia = :tipoOcorrencia)
    """)
    Page<JpaOcorrenciaEntity> findByDataBetweenAndTipoOcorrenciaOptional(
            @Param("inicio") LocalDateTime inicio,
            @Param("fim") LocalDateTime fim,
            @Param("tipoOcorrencia") TipoOcorrencia tipoOcorrencia,
            Pageable pageable
    );
}
