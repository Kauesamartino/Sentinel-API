package com.sentinel.api.application.usecases.estacao;

import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.repository.EstacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetEstacaoUseCaseImpl {

    private final EstacaoRepository repository;

    public Estacao execute(Long id) {
        return repository.findById(id);
    }
}
