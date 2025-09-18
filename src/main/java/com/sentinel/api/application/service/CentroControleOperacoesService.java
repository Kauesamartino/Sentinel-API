package com.sentinel.api.application.service;

import com.sentinel.api.application.exceptions.ValidationException;
import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.domain.repository.CentroControleOperacoesRepository;

public class CentroControleOperacoesService {

    private final CentroControleOperacoesRepository repository;

    public CentroControleOperacoesService(CentroControleOperacoesRepository repository) {
        this.repository = repository;
    }

    public void validate(CentroControleOperacoes centroControleOperacoes){
        if (centroControleOperacoes.getName() == null || centroControleOperacoes.getName().isEmpty()){
            throw new ValidationException("Nome inválido");
        }
    }

    public CentroControleOperacoes save(CentroControleOperacoes ocorrencia){
        return repository.save(ocorrencia);
    }

}
