package com.sentinel.api.interfaces.controller;

import com.sentinel.api.application.usecases.ocorrencia.CreateOcorrenciaInput;
import com.sentinel.api.application.usecases.ocorrencia.CreateOcorrenciaUseCase;
import com.sentinel.api.application.usecases.ocorrencia.UpdateOcorrenciaInput;
import com.sentinel.api.application.usecases.ocorrencia.UpdateOcorrenciaUseCase;
import com.sentinel.api.domain.entity.Ocorrencia;
import com.sentinel.api.infrastructure.repository.RelatorioRepository;
import com.sentinel.api.infrastructure.repository.OcorrenciaRepository;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaUpdateDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaInDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaOutDetailDto;
import com.sentinel.api.interfaces.dto.ocorrencia.DadosListagemOcorrencias;
import com.sentinel.api.interfaces.mapper.OcorrenciaMapper;
import jakarta.transaction.Transactional;
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

    private final RelatorioRepository relatorioRepository;
    private final OcorrenciaRepository ocorrenciaRepository;
    private final CreateOcorrenciaUseCase createOcorrenciaUseCase;
    private final UpdateOcorrenciaUseCase updateOcorrenciaUseCase;
    private final OcorrenciaMapper mapper;

    @PostMapping
    @Transactional
    public ResponseEntity<OcorrenciaOutDetailDto> cadastrar(@RequestBody @Valid OcorrenciaInDto dados, UriComponentsBuilder uriBuilder){
        CreateOcorrenciaInput ocorrenciaInput = mapper.inDtoToInput(dados);
        Ocorrencia createdOcorrencia =  createOcorrenciaUseCase.execute(ocorrenciaInput);
        OcorrenciaOutDetailDto ocorrenciaOutDetailDto = mapper.entityToOutDetailDto(createdOcorrencia);
        URI uri = uriBuilder.path("/ocorrencias/{id}").buildAndExpand(ocorrenciaOutDetailDto.id()).toUri();
        return ResponseEntity.created(uri).body(ocorrenciaOutDetailDto);
    }

    @GetMapping("relatorio/{id}")
    public ResponseEntity<Page<DadosListagemOcorrencias>> listarOcorrenciasDeUmRelatorio(@PathVariable Long id, @PageableDefault Pageable pageable){
        var relatorio = relatorioRepository.getReferenceById(id);
        var page = ocorrenciaRepository.findByDataBetweenAndTipoOcorrenciaOptional(
                relatorio.getDataInicio(),
                relatorio.getDataFim(),
                relatorio.getTipoOcorrencia(),
                pageable
        ).map(DadosListagemOcorrencias::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OcorrenciaOutDetailDto> detalhar(@PathVariable Long id){
        var ocorrencia = ocorrenciaRepository.getReferenceById(id);
        return ResponseEntity.ok(new OcorrenciaOutDetailDto(ocorrencia));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemOcorrencias>> listar(@PageableDefault(size = 20, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable){
        var page = ocorrenciaRepository.findAllByAtivoTrue(pageable).map(DadosListagemOcorrencias::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<OcorrenciaOutDetailDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid OcorrenciaUpdateDto dados){
        UpdateOcorrenciaInput input = mapper.updateDtoToInput(dados);
        Ocorrencia updatedOcorrencia = updateOcorrenciaUseCase.execute(id, input);
        OcorrenciaOutDetailDto ocorrenciaOutDetailDto = mapper.entityToOutDetailDto(updatedOcorrencia);
        return ResponseEntity.ok(ocorrenciaOutDetailDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        var ocorrencia = ocorrenciaRepository.getReferenceById(id);
        ocorrenciaRepository.deleteById(ocorrencia.getId());
        return ResponseEntity.noContent().build();
    }
}
