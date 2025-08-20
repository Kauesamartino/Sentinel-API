package com.sentinel.api.domain.ocorrencia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    Page<Ocorrencia> findAllByAtivoTrue(Pageable pageable);
}
