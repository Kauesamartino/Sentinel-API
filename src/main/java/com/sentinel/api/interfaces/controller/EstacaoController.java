package com.sentinel.api.interfaces.controller;

import com.sentinel.api.application.usecases.estacao.CreateEstacaoUseCase;
import com.sentinel.api.application.usecases.estacao.GetEstacaoUsecase;
import com.sentinel.api.application.usecases.estacao.GetEstacoesUseCase;
import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.infrastructure.repository.JpaEstacaoRepository;
import com.sentinel.api.interfaces.dto.estacao.EstacaoInDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoOutDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoLazyOutDto;
import com.sentinel.api.interfaces.mapper.ApiMapper;
import com.sentinel.api.interfaces.mapper.EstacaoMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("estacoes")
@RequiredArgsConstructor
public class EstacaoController {

    private final EstacaoMapper mapper;
    private final CreateEstacaoUseCase  createEstacaoUseCase;
    private final GetEstacoesUseCase  getEstacoesUseCase;
    private final ApiMapper apiMapper;
    private final GetEstacaoUsecase getEstacaoUsecase;

    @PostMapping
    @Transactional
    public ResponseEntity<EstacaoOutDto> cadastrar(@RequestBody @Valid EstacaoInDto dados, UriComponentsBuilder uriBuilder){
        Estacao estacao = mapper.inDtoToDomain(dados);
        Estacao createdEstacao = createEstacaoUseCase.execute(estacao);
        EstacaoOutDto estacaoOutDto = mapper.domainToOutDto(createdEstacao);
        URI uri = uriBuilder.path("/estacoes/{id}").buildAndExpand(estacao.getId()).toUri();
        return ResponseEntity.created(uri).body(estacaoOutDto);
    }

    @GetMapping
    public ResponseEntity<Page<EstacaoLazyOutDto>> listar(@RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                                                          @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber){

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Estacao> domainPage = getEstacoesUseCase.execute(pageable);
        Page<EstacaoLazyOutDto> dto = domainPage.map(apiMapper::estacaoToLazyDto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstacaoOutDto> detalhar(@PathVariable Long id){
        Estacao estacao = getEstacaoUsecase.execute(id);
        EstacaoOutDto estacaoOutDto = mapper.domainToOutDto(estacao);
        return ResponseEntity.ok(estacaoOutDto);
    }
}
