package com.sentinel.api.application.usecases.relatorio;

import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.domain.repository.RelatorioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateRelatorioUseCase {

    private final RelatorioRepository relatorioRepository;

    @Transactional
    public Relatorio execute(Relatorio relatorio) {
        if (relatorio == null) {
            throw new IllegalArgumentException("Relatorio não pode ser nulo");
        }
        return relatorioRepository.save(relatorio);
    }
}
