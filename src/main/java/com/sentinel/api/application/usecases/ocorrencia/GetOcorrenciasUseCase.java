package com.sentinel.api.application.usecases.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetOcorrenciasUseCase {

    private final OcorrenciaRepository ocorrenciaRepository;

    public Page<Ocorrencia> execute(Pageable pageable) {
        return ocorrenciaRepository.findAllByAtivoTrue(pageable);
    }
}
