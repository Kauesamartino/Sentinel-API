package com.sentinel.api.application.service;

import com.sentinel.api.application.exceptions.ValidationException;
import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.OcorrenciaRepository;
import jakarta.persistence.EntityNotFoundException;

public class OcorrenciaService {

    private final OcorrenciaRepository ocorrenciaRepository;

    public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    public Ocorrencia save(Ocorrencia ocorrencia) {
        if (ocorrencia.getTitulo() == null || ocorrencia.getTitulo().isEmpty()) {
            throw new ValidationException("Titulo de ocorrência é obrigatória");
        }
        if (ocorrencia.getDescricao() == null || ocorrencia.getDescricao().isEmpty()) {
            throw new ValidationException("Descrição de ocorrência é obrigatória");
        }
        if (ocorrencia.getSeveridade() == null){
            throw new ValidationException("Severidade de ocorrência é obrigatória");
        }
        if (ocorrencia.getTipoOcorrencia() == null) {
            throw new ValidationException("Tipo de ocorrência é obrigatório");
        }

        return ocorrenciaRepository.save(ocorrencia);
    }

    public void delete(Long id) {
        Ocorrencia ocorrencia = ocorrenciaRepository.findById(id);
        if (ocorrencia == null) {
            throw new EntityNotFoundException("Relatório não encontrado para id: " + id);
        }
        ocorrenciaRepository.delete(id);
    }
}
