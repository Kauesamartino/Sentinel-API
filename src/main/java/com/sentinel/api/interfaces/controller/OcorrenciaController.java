package com.sentinel.api.interfaces.controller;

import com.sentinel.api.application.usecases.ocorrencia.*;
import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.infrastructure.repository.JpaRelatorioRepository;
import com.sentinel.api.infrastructure.repository.JpaOcorrenciaRepository;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaUpdateDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaInDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaOutDetailDto;
import com.sentinel.api.interfaces.dto.ocorrencia.DadosListagemOcorrencias;
import com.sentinel.api.interfaces.mapper.OcorrenciaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("ocorrencias")
@RequiredArgsConstructor
public class OcorrenciaController {

    private final JpaRelatorioRepository jpaRelatorioRepository;
    private final JpaOcorrenciaRepository jpaOcorrenciaRepository;
    private final CreateOcorrenciaUseCase createOcorrenciaUseCase;
    private final UpdateOcorrenciaUseCase updateOcorrenciaUseCase;
    private final DeleteOcorrenciaUseCase deleteOcorrenciaUseCase;
    private final GetOcorrenciaUseCase getOcorrenciaUseCase;
    private final OcorrenciaMapper mapper;

    @PostMapping
    public ResponseEntity<OcorrenciaOutDetailDto> cadastrar(@RequestBody @Valid OcorrenciaInDto dados, UriComponentsBuilder uriBuilder){
        Ocorrencia ocorrencia = mapper.inDtoToDomain(dados);
        Ocorrencia createdOcorrencia =  createOcorrenciaUseCase.execute(ocorrencia);
        OcorrenciaOutDetailDto ocorrenciaOutDetailDto = mapper.domainToOutDto(createdOcorrencia);
        URI uri = uriBuilder.path("/ocorrencias/{id}").buildAndExpand(ocorrenciaOutDetailDto.id()).toUri();
        return ResponseEntity.created(uri).body(ocorrenciaOutDetailDto);
    }

    @GetMapping("relatorio/{id}")
    public ResponseEntity<Page<DadosListagemOcorrencias>> listarOcorrenciasDeUmRelatorio(@PathVariable Long id, @PageableDefault Pageable pageable){
        var relatorio = jpaRelatorioRepository.getReferenceById(id);
        var page = jpaOcorrenciaRepository.findByDataBetweenAndTipoOcorrenciaOptional(
                relatorio.getDataInicio(),
                relatorio.getDataFim(),
                relatorio.getTipoOcorrencia(),
                pageable
        ).map(DadosListagemOcorrencias::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OcorrenciaOutDetailDto> detalhar(@PathVariable Long id){
        Ocorrencia ocorrencia = getOcorrenciaUseCase.execute(id);
        OcorrenciaOutDetailDto dto = mapper.domainToOutDto(ocorrencia);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemOcorrencias>> listar(@PageableDefault(size = 20, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable){
        var page = jpaOcorrenciaRepository.findAllByAtivoTrue(pageable).map(DadosListagemOcorrencias::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OcorrenciaOutDetailDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid OcorrenciaUpdateDto dados){

        Ocorrencia ocorrencia = updateOcorrenciaUseCase.execute(id, mapper.updateDtoToDomain(dados));
        OcorrenciaOutDetailDto ocorrenciaOutDetailDto = mapper.domainToOutDto(ocorrencia);
        return ResponseEntity.ok(ocorrenciaOutDetailDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        deleteOcorrenciaUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
