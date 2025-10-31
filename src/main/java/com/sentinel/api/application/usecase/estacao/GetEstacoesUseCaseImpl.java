package com.sentinel.api.application.usecase.estacao;

import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.repository.EstacaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public final class GetEstacoesUseCaseImpl implements GetEstacoesUseCase {

    private final EstacaoRepository estacaoRepository;

    public GetEstacoesUseCaseImpl(EstacaoRepository estacaoRepository) {
        this.estacaoRepository = estacaoRepository;
    }

    public Page<Estacao> execute(Pageable pageable) {
        return estacaoRepository.findAll(pageable);
    }
}
