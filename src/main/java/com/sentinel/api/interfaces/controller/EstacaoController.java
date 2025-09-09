package com.sentinel.api.interfaces.controller;

import com.sentinel.api.application.usecases.estacao.CreateEstacaoUseCase;
import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.infrastructure.repository.JpaEstacaoRepository;
import com.sentinel.api.interfaces.dto.estacao.EstacaoInDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoOutDto;
import com.sentinel.api.interfaces.dto.estacao.DadosListagemEstacoes;
import com.sentinel.api.interfaces.mapper.EstacaoMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("estacoes")
@RequiredArgsConstructor
public class EstacaoController {

    private final EstacaoMapper mapper;
    private final JpaEstacaoRepository jpaEstacaoRepository;
    private final CreateEstacaoUseCase  createEstacaoUseCase;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EstacaoInDto dados, UriComponentsBuilder uriBuilder){
        Estacao estacao = mapper.inDtoToDomain(dados);
        Estacao createdEstacao = createEstacaoUseCase.execute(estacao);
        EstacaoOutDto estacaoOutDto = mapper.domainToOutDto(createdEstacao);
        URI uri = uriBuilder.path("/estacoes/{id}").buildAndExpand(estacao.getId()).toUri();
        return ResponseEntity.created(uri).body(estacaoOutDto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemEstacoes>> listar(@PageableDefault(size = 10) Pageable pageable){
        var page = jpaEstacaoRepository.findAll(pageable).map(DadosListagemEstacoes::new);
        return ResponseEntity.ok(page);
    }
}
