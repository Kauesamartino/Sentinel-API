package com.sentinel.api.interfaces.controller;

import com.sentinel.api.application.usecase.estacao.CreateEstacaoUseCaseImpl;
import com.sentinel.api.application.usecase.estacao.DeleteEstacaoUseCaseImpl;
import com.sentinel.api.application.usecase.estacao.GetEstacaoUseCaseImpl;
import com.sentinel.api.application.usecase.estacao.GetEstacoesUseCaseImpl;
import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.interfaces.dto.estacao.EstacaoInDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoOutDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoLazyOutDto;
import com.sentinel.api.interfaces.mapper.ApiMapper;
import com.sentinel.api.interfaces.mapper.EstacaoMapper;
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
    private final CreateEstacaoUseCaseImpl createEstacaoUseCaseImpl;
    private final GetEstacoesUseCaseImpl getEstacoesUseCaseImpl;
    private final ApiMapper apiMapper;
    private final GetEstacaoUseCaseImpl getEstacaoUseCaseImpl;
    private final DeleteEstacaoUseCaseImpl deleteEstacaoUseCaseImpl;

    @PostMapping
    public ResponseEntity<EstacaoOutDto> cadastrar(@RequestBody @Valid EstacaoInDto dados, UriComponentsBuilder uriBuilder){
        Estacao estacao = mapper.inDtoToDomain(dados);
        Estacao createdEstacao = createEstacaoUseCaseImpl.execute(estacao);
        EstacaoOutDto estacaoOutDto = mapper.domainToOutDto(createdEstacao);
        URI uri = uriBuilder.path("/estacoes/{id}").buildAndExpand(estacao.getId()).toUri();
        return ResponseEntity.created(uri).body(estacaoOutDto);
    }

    @GetMapping
    public ResponseEntity<Page<EstacaoLazyOutDto>> listar(@RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                                                          @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber){

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Estacao> domainPage = getEstacoesUseCaseImpl.execute(pageable);
        Page<EstacaoLazyOutDto> dto = domainPage.map(apiMapper::estacaoToLazyDto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstacaoOutDto> detalhar(@PathVariable Long id){
        Estacao estacao = getEstacaoUseCaseImpl.execute(id);
        EstacaoOutDto estacaoOutDto = mapper.domainToOutDto(estacao);
        return ResponseEntity.ok(estacaoOutDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        deleteEstacaoUseCaseImpl.execute(id);
        return ResponseEntity.noContent().build();
    }
}
