package com.sentinel.api.application.service;

import com.sentinel.api.application.exceptions.ocorrencia.OcorrenciaDescricaoInvalidaException;
import com.sentinel.api.application.exceptions.ocorrencia.OcorrenciaSeveridadeInvalidaException;
import com.sentinel.api.application.exceptions.ocorrencia.OcorrenciaTipoInvalidoException;
import com.sentinel.api.application.exceptions.ocorrencia.OcorrenciaTituloInvalidoException;
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
            throw new OcorrenciaTituloInvalidoException();
        }
        if (ocorrencia.getDescricao() == null || ocorrencia.getDescricao().isEmpty()) {
            throw new OcorrenciaDescricaoInvalidaException();
        }
        if (ocorrencia.getSeveridade() == null){
            throw new OcorrenciaSeveridadeInvalidaException();
        }
        if (ocorrencia.getTipoOcorrencia() == null) {
            throw new OcorrenciaTipoInvalidoException();
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
