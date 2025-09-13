package com.sentinel.api.application.usecase.relatorio;

import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.domain.repository.RelatorioRepository;
import com.sentinel.api.domain.usecase.relatorio.GetRelatoriosUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetRelatoriosUseCaseImpl implements GetRelatoriosUseCase {

    private final RelatorioRepository relatorioRepository;

    public Page<Relatorio> execute(Pageable pageable) {
        return relatorioRepository.findAll(pageable);
    }
}
