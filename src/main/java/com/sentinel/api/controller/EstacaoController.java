package com.sentinel.api.controller;

import com.sentinel.api.domain.cco.CentroControleOperacoesRepository;
import com.sentinel.api.domain.estacao.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity<Page<DadosListagemEstacoes>> listar(@PageableDefault(size = 10) Pageable pageable){
        var page = estacaoRepository.findAll(pageable).map(DadosListagemEstacoes::new);
        return ResponseEntity.ok(page);
    }
}
