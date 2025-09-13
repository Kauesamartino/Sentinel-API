package com.sentinel.api.application.usecases.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateOcorrenciaUseCaseImpl {
    private final OcorrenciaRepository ocorrenciaRepository;

    @Transactional
    public Ocorrencia execute(Long id, Ocorrencia ocorrenciaAtualizada) {
        Ocorrencia ocorrenciaExistente = ocorrenciaRepository.findById(id);

        ocorrenciaExistente.setTitulo(ocorrenciaAtualizada.getTitulo());
        ocorrenciaExistente.setDescricao(ocorrenciaAtualizada.getDescricao());
        ocorrenciaExistente.setStatus(ocorrenciaAtualizada.getStatus());
        ocorrenciaExistente.setSeveridade(ocorrenciaAtualizada.getSeveridade());
        ocorrenciaExistente.setTipoOcorrencia(ocorrenciaAtualizada.getTipoOcorrencia());
        ocorrenciaExistente.setAtivo(ocorrenciaAtualizada.getAtivo());

        return ocorrenciaRepository.save(ocorrenciaExistente);
    }
}
