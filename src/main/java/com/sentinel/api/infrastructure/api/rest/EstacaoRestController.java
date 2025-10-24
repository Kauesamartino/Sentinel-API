package com.sentinel.api.infrastructure.api.rest;

import com.sentinel.api.interfaces.controller.EstacaoController;
import com.sentinel.api.interfaces.dto.estacao.EstacaoInDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoLazyOutDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoOutDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Adaptador REST para o controller de Estacao.
 * Esta classe contém as anotações específicas do springframework e
 * delega as chamadas para o controller puro.
 */
@RestController
@RequestMapping("/estacoes")
public class EstacaoRestController {

    private final EstacaoController estacaoController;

    public EstacaoRestController(EstacaoController estacaoController) {
        this.estacaoController = estacaoController;
    }

    @PostMapping
    public ResponseEntity<EstacaoOutDto> cadastrar(@RequestBody @Valid EstacaoInDto dados, UriComponentsBuilder uriBuilder){
        EstacaoOutDto estacaoOutDto = estacaoController.cadastrar(dados);
        URI uri = uriBuilder.path("/estacoes/{id}").buildAndExpand(estacaoOutDto.id()).toUri();
        return ResponseEntity.created(uri).body(estacaoOutDto);
    }

    @GetMapping
    public ResponseEntity<Page<EstacaoLazyOutDto>> listar(@RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                                                          @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber){

        Page<EstacaoLazyOutDto> dto = estacaoController.listar(pageSize, pageNumber);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstacaoOutDto> detalhar(@PathVariable Long id){
        EstacaoOutDto estacaoOutDto = estacaoController.detalhar(id);
        return ResponseEntity.ok(estacaoOutDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        estacaoController.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
