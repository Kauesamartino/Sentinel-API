package com.sentinel.api.interfaces.controller;

import com.sentinel.api.infrastructure.entity.JpaCentroControleOperacoesEntity;
import com.sentinel.api.infrastructure.repository.JpaCentroControleOperacoesRepository;
import com.sentinel.api.interfaces.dto.cco.DadosCadastroCentroControleOperacoes;
import com.sentinel.api.interfaces.dto.cco.CcoOutDto;
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

    private final JpaCentroControleOperacoesRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastroCentroControleOperacoes dados, UriComponentsBuilder uriBuilder){
        var cco = new JpaCentroControleOperacoesEntity(dados);
        repository.save(cco);
        var uri = uriBuilder.path("/cco/{id}").buildAndExpand(cco.getId()).toUri();
        return ResponseEntity.created(uri).body(new CcoOutDto(cco));
    }
}
