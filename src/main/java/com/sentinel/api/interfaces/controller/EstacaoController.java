package com.sentinel.api.interfaces.controller;

import com.sentinel.api.application.usecase.cco.GetCcoUseCase;
import com.sentinel.api.application.usecase.estacao.CreateEstacaoUseCase;
import com.sentinel.api.application.usecase.estacao.DeleteEstacaoUseCase;
import com.sentinel.api.application.usecase.estacao.GetEstacaoUseCase;
import com.sentinel.api.application.usecase.estacao.GetEstacoesUseCase;
import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.interfaces.dto.estacao.EstacaoInDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoOutDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoLazyOutDto;
import com.sentinel.api.interfaces.mapper.ApiMapper;
import com.sentinel.api.interfaces.mapper.EstacaoMapper;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("estacoes")
public class EstacaoController {

    private final CreateEstacaoUseCase createEstacaoUseCase;
    private final GetEstacoesUseCase getEstacoesUseCase;
    private final GetEstacaoUseCase getEstacaoUseCase;
    private final DeleteEstacaoUseCase deleteEstacaoUseCase;
    private final GetCcoUseCase getCcoUseCase;

    public EstacaoController(CreateEstacaoUseCase createEstacaoUseCase, GetEstacoesUseCase getEstacoesUseCase, GetEstacaoUseCase getEstacaoUseCase, DeleteEstacaoUseCase deleteEstacaoUseCase, GetCcoUseCase getCcoUseCase) {
        this.createEstacaoUseCase = createEstacaoUseCase;
        this.getEstacoesUseCase = getEstacoesUseCase;
        this.getEstacaoUseCase = getEstacaoUseCase;
        this.deleteEstacaoUseCase = deleteEstacaoUseCase;
        this.getCcoUseCase = getCcoUseCase;
    }

    @PostMapping
    public ResponseEntity<EstacaoOutDto> cadastrar(@RequestBody @Valid EstacaoInDto dados, UriComponentsBuilder uriBuilder){
        Estacao estacao = EstacaoMapper.inDtoToDomain(dados);
        Estacao createdEstacao = createEstacaoUseCase.execute(estacao);
        EstacaoOutDto estacaoOutDto = EstacaoMapper.domainToOutDto(createdEstacao, getCcoUseCase.execute(createdEstacao.getIdCco()));
        URI uri = uriBuilder.path("/estacoes/{id}").buildAndExpand(estacao.getId()).toUri();
        return ResponseEntity.created(uri).body(estacaoOutDto);
    }

    @GetMapping
    public ResponseEntity<Page<EstacaoLazyOutDto>> listar(@RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                                                          @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber){

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Estacao> domainPage = getEstacoesUseCase.execute(pageable);
        Page<EstacaoLazyOutDto> dto = domainPage.map(ApiMapper::estacaoToLazyDto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstacaoOutDto> detalhar(@PathVariable Long id){
        Estacao estacao = getEstacaoUseCase.execute(id);
        EstacaoOutDto estacaoOutDto = EstacaoMapper.domainToOutDto(estacao, getCcoUseCase.execute(estacao.getIdCco()));
        return ResponseEntity.ok(estacaoOutDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        deleteEstacaoUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
