package com.sentinel.api.controller;

import com.sentinel.api.domain.cco.CentroControleOperacoesRepository;
import com.sentinel.api.domain.estacao.DadosCadastroEstacao;
import com.sentinel.api.domain.estacao.DadosDetalhamentoEstacao;
import com.sentinel.api.domain.estacao.Estacao;
import com.sentinel.api.domain.estacao.EstacaoRepository;
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
@RequestMapping("estacoes")
@RequiredArgsConstructor
public class EstacaoController {

    private final CentroControleOperacoesRepository ccoRepository;

    private final EstacaoRepository estacaoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastroEstacao dados, UriComponentsBuilder uriBuilder){
        var cco = ccoRepository.getReferenceById(dados.idCco());
        var estacao = new Estacao(dados, cco);
        estacaoRepository.save(estacao);
        var uri = uriBuilder.path("/estacoes/{id}").buildAndExpand(estacao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEstacao(estacao));
    }
}
