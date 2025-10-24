package com.sentinel.api.infrastructure.api.rest;

import com.sentinel.api.interfaces.controller.RelatorioController;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioInDto;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioLazyOutDto;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioOutDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/relatorios")
public class RelatorioRestController {

    private final RelatorioController relatorioController;

    public RelatorioRestController(RelatorioController relatorioController) {
        this.relatorioController = relatorioController;
    }

    @PostMapping
    public ResponseEntity<RelatorioOutDto> cadastrar(@RequestBody @Valid RelatorioInDto dados, UriComponentsBuilder uriBuilder){

        RelatorioOutDto dto = relatorioController.cadastrar(dados);
        URI uri = uriBuilder.path("/relatorios/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<RelatorioLazyOutDto>> listar(@RequestParam(name = "sizePage", required = false, defaultValue = "20") Integer pageSize,
                                                            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                                            @RequestParam(name = "direction", required = false, defaultValue = "DESC") Sort.Direction direction) {

        Page<RelatorioLazyOutDto> dto = relatorioController.listar(pageSize, pageNumber, direction);
        return ResponseEntity.ok(dto);
    }
}
