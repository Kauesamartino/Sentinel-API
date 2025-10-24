package com.sentinel.api.infrastructure.api.rest;

import com.sentinel.api.interfaces.controller.OcorrenciaController;
import com.sentinel.api.interfaces.controller.OcorrenciaControllerImpl;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaInDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaLazyOutDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaOutDetailDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Adaptador REST para o controller de Ocorrencia.
 * Esta classe contém as anotações específicas do springframework e
 * delega as chamadas para o controller puro.
 */
@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaRestController {

    private final OcorrenciaController ocorrenciaController;

    public OcorrenciaRestController(OcorrenciaController ocorrenciaController) {
        this.ocorrenciaController = ocorrenciaController;
    }

    @PostMapping
    public ResponseEntity<OcorrenciaOutDetailDto> cadastrar(@RequestBody OcorrenciaInDto ocorrenciaInDto, UriComponentsBuilder uriBuilder) {
        final OcorrenciaOutDetailDto dto = ocorrenciaController.cadastrar(ocorrenciaInDto);
        URI uri = uriBuilder.path("/ocorrencias/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("relatorio/{id}")
    public ResponseEntity<Page<OcorrenciaLazyOutDto>> listarOcorrenciasDeUmRelatorio(@PathVariable Long id,
                                                                                     @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                                                                                     @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                                                                     @RequestParam(name = "direction", required = false, defaultValue = "DESC") Sort.Direction direction){

        Page<OcorrenciaLazyOutDto> page = ocorrenciaController.listarOcorrenciasDeUmRelatorio(id, pageSize, pageNumber, direction);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OcorrenciaOutDetailDto> detalhar(@PathVariable Long id) {
        OcorrenciaOutDetailDto dto = ocorrenciaController.detalhar(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<OcorrenciaLazyOutDto>> listar(@RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                                                            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                                            @RequestParam(name = "direction", required = false, defaultValue = "DESC") Sort.Direction direction) {

        Page<OcorrenciaLazyOutDto> page = ocorrenciaController.listar(pageSize, pageNumber, direction);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/curadoria")
    public ResponseEntity<Page<OcorrenciaLazyOutDto>> listarOcorrenciasCuradoria(@RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                                                                                   @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                                                                   @RequestParam(name = "direction", required = false, defaultValue = "DESC") Sort.Direction direction){

        Page<OcorrenciaLazyOutDto> page = ocorrenciaController.listarOcorrenciasCuradoria(pageSize, pageNumber, direction);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OcorrenciaOutDetailDto> atualizar(@PathVariable Long id, @RequestBody OcorrenciaUpdateDto dados) {
        OcorrenciaOutDetailDto dto = ocorrenciaController.atualizar(id, dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        ocorrenciaController.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> ativar(@PathVariable Long id) {
        ocorrenciaController.ativar(id);
        return ResponseEntity.noContent().build();
    }
}
