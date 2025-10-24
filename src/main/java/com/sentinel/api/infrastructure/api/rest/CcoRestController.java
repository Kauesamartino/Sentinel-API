package com.sentinel.api.infrastructure.api.rest;

import com.sentinel.api.interfaces.controller.CentroControleOperacoesController;
import com.sentinel.api.interfaces.dto.cco.CcoInDto;
import com.sentinel.api.interfaces.dto.cco.CcoOutDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Adaptador REST para o controller de Ocorrencia.
 * Esta classe contém as anotações específicas do springframework e
 * delega as chamadas para o controller puro.
 */
@RestController
@RequestMapping("/ccos")
public class CcoRestController {

    private final CentroControleOperacoesController centroControleOperacoesController;

    public CcoRestController(CentroControleOperacoesController centroControleOperacoesController) {
        this.centroControleOperacoesController = centroControleOperacoesController;
    }

    public ResponseEntity<CcoOutDto> cadastrar(@RequestBody @Valid CcoInDto dados, UriComponentsBuilder uriBuilder){
        CcoOutDto dto = centroControleOperacoesController.cadastrar(dados);
        URI uri = uriBuilder.path("/cco/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
