package com.sentinel.api.application.usecase.ocorrencia;

import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;


public final class UpdateOcorrenciaUseCaseImpl implements UpdateOcorrenciaUseCase {

    private final OcorrenciaRepository ocorrenciaRepository;

    public UpdateOcorrenciaUseCaseImpl(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

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
