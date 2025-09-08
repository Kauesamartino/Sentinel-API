package com.sentinel.api.interfaces.controller;

import com.sentinel.api.domain.cco.CentroControleOperacoes;
import com.sentinel.api.domain.cco.CentroControleOperacoesRepository;
import com.sentinel.api.domain.cco.DadosCadastroCentroControleOperacoes;
import com.sentinel.api.domain.cco.DadosDetalhamentoCentroControleOperacoes;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cco")
@RequiredArgsConstructor
public class CentroControleOperacoesController {

    private final CentroControleOperacoesRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastroCentroControleOperacoes dados, UriComponentsBuilder uriBuilder){
        var cco = new CentroControleOperacoes(dados);
        repository.save(cco);
        var uri = uriBuilder.path("/cco/{id}").buildAndExpand(cco.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCentroControleOperacoes(cco));
    }
}
