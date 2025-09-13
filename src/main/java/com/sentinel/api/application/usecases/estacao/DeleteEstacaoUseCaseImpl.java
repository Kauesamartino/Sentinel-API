package com.sentinel.api.application.usecases.estacao;

import com.sentinel.api.domain.repository.EstacaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteEstacaoUseCaseImpl {

    private final EstacaoRepository repository;

    @Transactional
    public void execute(Long id){
        repository.delete(id);
    }

}
