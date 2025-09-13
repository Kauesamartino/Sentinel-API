package com.sentinel.api.application.usecase.relatorio;

import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.domain.repository.RelatorioRepository;
import com.sentinel.api.domain.usecase.relatorio.CreateRelatorioUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateRelatorioUseCaseImpl implements CreateRelatorioUseCase {

    private final RelatorioRepository relatorioRepository;

    @Transactional
    public Relatorio execute(Relatorio relatorio) {
        if (relatorio == null) {
            throw new IllegalArgumentException("Relatorio não pode ser nulo");
        }
        return relatorioRepository.save(relatorio);
    }
}
