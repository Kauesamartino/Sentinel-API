package com.sentinel.api.application.usecase.estacao;

import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.repository.EstacaoRepository;
import com.sentinel.api.domain.usecase.estacao.CreateEstacaoUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEstacaoUseCaseImpl implements CreateEstacaoUseCase {

    private final EstacaoRepository estacaoRepository;

    @Transactional
    public Estacao execute(Estacao estacao) {
        if (estacao == null) {
            throw new IllegalArgumentException("Estação não pode ser nula");
        }
        return estacaoRepository.save(estacao);
    }
}
