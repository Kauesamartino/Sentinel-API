package com.sentinel.api.application.usecases.estacao;

import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.repository.EstacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetEstacoesUseCaseImpl {

    private final EstacaoRepository estacaoRepository;

    public Page<Estacao> execute(Pageable pageable) {
        return estacaoRepository.findAll(pageable);
    }
}
