package com.sentinel.api.application.usecase.relatorio;

import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.domain.repository.RelatorioRepository;


public final class CreateRelatorioUseCaseImpl implements CreateRelatorioUseCase {

    private final RelatorioRepository relatorioRepository;

    public CreateRelatorioUseCaseImpl(RelatorioRepository relatorioRepository) {
        this.relatorioRepository = relatorioRepository;
    }

    public Relatorio execute(Relatorio relatorio) {
        if (relatorio == null) {
            throw new IllegalArgumentException("Relatorio não pode ser nulo");
        }
        return relatorioRepository.save(relatorio);
    }
}
