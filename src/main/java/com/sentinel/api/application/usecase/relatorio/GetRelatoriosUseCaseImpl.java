package com.sentinel.api.application.usecase.relatorio;

import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.domain.repository.RelatorioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public final class GetRelatoriosUseCaseImpl implements GetRelatoriosUseCase {

    private final RelatorioRepository relatorioRepository;

    public GetRelatoriosUseCaseImpl(RelatorioRepository relatorioRepository) {
        this.relatorioRepository = relatorioRepository;
    }

    public Page<Relatorio> execute(Pageable pageable) {
        return relatorioRepository.findAll(pageable);
    }
}
