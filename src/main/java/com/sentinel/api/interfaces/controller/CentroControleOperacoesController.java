package com.sentinel.api.interfaces.controller;

import com.sentinel.api.application.usecase.cco.CreateCcoUseCaseImpl;
import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.interfaces.dto.cco.CcoInDto;
import com.sentinel.api.interfaces.dto.cco.CcoOutDto;
import com.sentinel.api.interfaces.mapper.CentroControleOperacoesMapper;
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

    private final CreateCcoUseCaseImpl  createCcoUseCaseImpl;
    private final CentroControleOperacoesMapper mapper;

    @PostMapping
    public ResponseEntity<CcoOutDto> cadastrar(@RequestBody @Valid CcoInDto dados, UriComponentsBuilder uriBuilder){
        CentroControleOperacoes centroControleOperacoes = mapper.inDtoToDomain(dados);
        CentroControleOperacoes createdCco = createCcoUseCaseImpl.execute(centroControleOperacoes);
        CcoOutDto dto = mapper.domainToOutDto(createdCco);
        var uri = uriBuilder.path("/cco/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
