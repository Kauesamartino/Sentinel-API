package com.sentinel.api.controller;

import com.sentinel.api.domain.estacao.EstacaoRepository;
import com.sentinel.api.domain.ocorrencia.*;
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

    @GetMapping
    public ResponseEntity<Page<DadosListagemOcorrencias>> listar(@PageableDefault(size = 10) Pageable pageable){
        var page = ocorrenciaRepository.findAllByAtivoTrue(pageable).map(DadosListagemOcorrencias::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@RequestBody @Valid DadosAtualizacaoOcorrencia dados){
        var ocorrencia = ocorrenciaRepository.getReferenceById(dados.id());
        ocorrencia.atualizarInformacoes(dados);
        return ResponseEntity.ok(new  DadosDetalhamentoOcorrencia(ocorrencia));
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id){
        var ocorrencia = ocorrenciaRepository.getReferenceById(id);
        ocorrencia.excluir();
        return ResponseEntity.noContent().build();
    }
}
