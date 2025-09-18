package com.sentinel.api.application.service;

import com.sentinel.api.application.validation.DataValidator;
import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.domain.repository.RelatorioRepository;

public class RelatorioService {

    private final RelatorioRepository relatorioRepository;


    public RelatorioService(RelatorioRepository relatorioRepository) {
        this.relatorioRepository = relatorioRepository;
    }

    public Relatorio save(Relatorio relatorio) {
        DataValidator.validarInicioMenorQueFim(relatorio.getDataInicio(), relatorio.getDataFim());
        DataValidator.validarAntecedenciaMinima(relatorio.getDataInicio(), relatorio.getDataFim(), 1);


        return relatorioRepository.save(relatorio);
    }
}
