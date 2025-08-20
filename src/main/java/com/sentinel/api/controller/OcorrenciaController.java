package com.sentinel.api.controller;

import com.sentinel.api.domain.estacao.EstacaoRepository;
import com.sentinel.api.domain.ocorrencia.DadosCadastroOcorrencia;
import com.sentinel.api.domain.ocorrencia.DadosDetalhamentoOcorrencia;
import com.sentinel.api.domain.ocorrencia.Ocorrencia;
import com.sentinel.api.domain.ocorrencia.OcorrenciaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("ocorrencias")
@RequiredArgsConstructor
public class OcorrenciaController {

    private final EstacaoRepository estacaoRepository;

    private final OcorrenciaRepository ocorrenciaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastroOcorrencia dados, UriComponentsBuilder uriBuilder){
        var estacao = estacaoRepository.getReferenceById(dados.idEstacao());
        var ocorrencia = new Ocorrencia(dados, estacao);
        ocorrenciaRepository.save(ocorrencia);
        var uri = uriBuilder.path("/ocorrencias/{id}").buildAndExpand(ocorrencia.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoOcorrencia(ocorrencia));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhar(@PathVariable Long id){
        var ocorrencia = ocorrenciaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoOcorrencia(ocorrencia));
    }

}
