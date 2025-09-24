package com.sentinel.api.interfaces.controller;

import com.sentinel.api.application.usecase.ocorrencia.*;
import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaUpdateDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaInDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaOutDetailDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaLazyOutDto;
import com.sentinel.api.interfaces.mapper.ApiMapper;
import com.sentinel.api.interfaces.mapper.OcorrenciaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("ocorrencias")
@RequiredArgsConstructor
public class OcorrenciaController {

    private final CreateOcorrenciaUseCaseImpl createOcorrenciaUseCaseImpl;
    private final UpdateOcorrenciaUseCaseImpl updateOcorrenciaUseCaseImpl;
    private final DeleteOcorrenciaUseCaseImpl deleteOcorrenciaUseCaseImpl;
    private final GetOcorrenciasUseCaseImpl getOcorrenciasUseCaseImpl;
    private final GetOcorrenciaUseCaseImpl getOcorrenciaUseCaseImpl;
    private final GetOcorrenciasRelatorioUseCaseImpl getOcorrenciasRelatorioUseCaseImpl;
    private final GetOcorrenciasAtivoFalseUseCaseImpl getOcorrenciasAtivoFalseUseCaseImpl;
    private final ApiMapper apiMapper;
    private final OcorrenciaMapper mapper;


    @PostMapping
    public ResponseEntity<OcorrenciaOutDetailDto> cadastrar(@RequestBody @Valid OcorrenciaInDto dados, UriComponentsBuilder uriBuilder){
        Ocorrencia ocorrencia = mapper.inDtoToDomain(dados);
        Ocorrencia createdOcorrencia =  createOcorrenciaUseCaseImpl.execute(ocorrencia);
        OcorrenciaOutDetailDto ocorrenciaOutDetailDto = mapper.domainToOutDto(createdOcorrencia);
        URI uri = uriBuilder.path("/ocorrencias/{id}").buildAndExpand(ocorrenciaOutDetailDto.id()).toUri();
        return ResponseEntity.created(uri).body(ocorrenciaOutDetailDto);
    }

    @GetMapping("relatorio/{id}")
    public ResponseEntity<Page<OcorrenciaLazyOutDto>> listarOcorrenciasDeUmRelatorio(@PathVariable Long id,
                                                                                     @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                                                                                     @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                                                                     @RequestParam(name = "direction", required = false, defaultValue = "DESC") Sort.Direction direction){

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, "id"));
        Page<Ocorrencia> domainPage = getOcorrenciasRelatorioUseCaseImpl.execute(id, pageable);
        Page<OcorrenciaLazyOutDto> dtoPage = domainPage.map(apiMapper::ocorrenciaToLazyDto);
        return ResponseEntity.ok(dtoPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OcorrenciaOutDetailDto> detalhar(@PathVariable Long id){
        Ocorrencia ocorrencia = getOcorrenciaUseCaseImpl.execute(id);
        OcorrenciaOutDetailDto dto = mapper.domainToOutDto(ocorrencia);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<OcorrenciaLazyOutDto>> listar(@RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                                                             @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                                             @RequestParam(name = "direction", required = false, defaultValue = "DESC") Sort.Direction direction){

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, "id"));
        Page<Ocorrencia> domainPage = this.getOcorrenciasUseCaseImpl.execute(pageable);
        Page<OcorrenciaLazyOutDto> dtoPage = domainPage.map(apiMapper::ocorrenciaToLazyDto);
        return ResponseEntity.ok(dtoPage);
    }

    @GetMapping
    public ResponseEntity<Page<OcorrenciaLazyOutDto>> listarOcorrenciasCuradoria(@RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                                                                                 @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                                                                 @RequestParam(name = "direction", required = false, defaultValue = "DESC") Sort.Direction direction){

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, "id"));
        Page<Ocorrencia> domainPage = this.getOcorrenciasAtivoFalseUseCaseImpl.execute(pageable);
        Page<OcorrenciaLazyOutDto> dtoPage = domainPage.map(apiMapper::ocorrenciaToLazyDto);
        return ResponseEntity.ok(dtoPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OcorrenciaOutDetailDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid OcorrenciaUpdateDto dados){

        Ocorrencia ocorrencia = updateOcorrenciaUseCaseImpl.execute(id, mapper.updateDtoToDomain(dados));
        OcorrenciaOutDetailDto ocorrenciaOutDetailDto = mapper.domainToOutDto(ocorrencia);
        return ResponseEntity.ok(ocorrenciaOutDetailDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        deleteOcorrenciaUseCaseImpl.execute(id);
        return ResponseEntity.noContent().build();
    }
}
