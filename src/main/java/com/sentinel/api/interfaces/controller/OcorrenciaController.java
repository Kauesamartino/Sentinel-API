package com.sentinel.api.interfaces.controller;

import com.sentinel.api.application.usecase.camera.GetCameraUseCase;
import com.sentinel.api.application.usecase.camera.GetCameraUseCaseImpl;
import com.sentinel.api.application.usecase.cco.GetCcoUseCase;
import com.sentinel.api.application.usecase.estacao.GetEstacaoUseCase;
import com.sentinel.api.application.usecase.ocorrencia.*;
import com.sentinel.api.domain.model.Camera;
import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaUpdateDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaInDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaOutDetailDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaLazyOutDto;
import com.sentinel.api.interfaces.mapper.ApiMapper;
import com.sentinel.api.interfaces.mapper.OcorrenciaMapper;
import jakarta.validation.Valid;
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
public class OcorrenciaController {

    private final CreateOcorrenciaUseCase createOcorrenciaUseCase;
    private final UpdateOcorrenciaUseCase updateOcorrenciaUseCase;
    private final DeleteOcorrenciaUseCase deleteOcorrenciaUseCase;
    private final GetOcorrenciasUseCase getOcorrenciasUseCase;
    private final GetOcorrenciaUseCase getOcorrenciaUseCase;
    private final GetOcorrenciasRelatorioUseCase getOcorrenciasRelatorioUseCase;
    private final GetOcorrenciasAtivoFalseUseCase getOcorrenciasAtivoFalseUseCase;
    private final PatchOcorrenciaAtivoUseCase patchOcorrenciaAtivoUseCase;
    private final GetCameraUseCase getCameraUseCase;
    private final GetEstacaoUseCase getEstacaoUseCase;
    private final GetCcoUseCase getCcoUseCase;

    public OcorrenciaController(CreateOcorrenciaUseCase createOcorrenciaUseCase, UpdateOcorrenciaUseCase updateOcorrenciaUseCase, DeleteOcorrenciaUseCase deleteOcorrenciaUseCase, GetOcorrenciasUseCase getOcorrenciasUseCase, GetOcorrenciaUseCase getOcorrenciaUseCase, GetOcorrenciasRelatorioUseCase getOcorrenciasRelatorioUseCase, GetOcorrenciasAtivoFalseUseCase getOcorrenciasAtivoFalseUseCase, PatchOcorrenciaAtivoUseCase patchOcorrenciaAtivoUseCase, GetCameraUseCase getCameraUseCase, GetEstacaoUseCase getEstacaoUseCase, GetCcoUseCase getCcoUseCase) {
        this.createOcorrenciaUseCase = createOcorrenciaUseCase;
        this.updateOcorrenciaUseCase = updateOcorrenciaUseCase;
        this.deleteOcorrenciaUseCase = deleteOcorrenciaUseCase;
        this.getOcorrenciasUseCase = getOcorrenciasUseCase;
        this.getOcorrenciaUseCase = getOcorrenciaUseCase;
        this.getOcorrenciasRelatorioUseCase = getOcorrenciasRelatorioUseCase;
        this.getOcorrenciasAtivoFalseUseCase = getOcorrenciasAtivoFalseUseCase;
        this.patchOcorrenciaAtivoUseCase = patchOcorrenciaAtivoUseCase;
        this.getCameraUseCase = getCameraUseCase;
        this.getEstacaoUseCase = getEstacaoUseCase;
        this.getCcoUseCase = getCcoUseCase;
    }


    @PostMapping
    public ResponseEntity<OcorrenciaOutDetailDto> cadastrar(@RequestBody @Valid OcorrenciaInDto dados, UriComponentsBuilder uriBuilder){
        Ocorrencia ocorrencia = OcorrenciaMapper.inDtoToDomain(dados);
        Ocorrencia createdOcorrencia =  createOcorrenciaUseCase.execute(ocorrencia);
        OcorrenciaOutDetailDto dto = OcorrenciaMapper.domainToOutDto(createdOcorrencia, getEstacaoUseCase.execute(ocorrencia.getIdEstacao()), getCameraUseCase.execute(ocorrencia.getIdCamera()), getCcoUseCase.execute(getEstacaoUseCase.execute(ocorrencia.getIdEstacao()).getId()));
        URI uri = uriBuilder.path("/ocorrencias/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("relatorio/{id}")
    public ResponseEntity<Page<OcorrenciaLazyOutDto>> listarOcorrenciasDeUmRelatorio(@PathVariable Long id,
                                                                                     @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                                                                                     @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                                                                     @RequestParam(name = "direction", required = false, defaultValue = "DESC") Sort.Direction direction){

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, "id"));
        Page<Ocorrencia> domainPage = getOcorrenciasRelatorioUseCase.execute(id, pageable);
        Page<OcorrenciaLazyOutDto> dtoPage = domainPage.map(ApiMapper::ocorrenciaToLazyDto);
        return ResponseEntity.ok(dtoPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OcorrenciaOutDetailDto> detalhar(@PathVariable Long id){
        Ocorrencia ocorrencia = getOcorrenciaUseCase.execute(id);
        OcorrenciaOutDetailDto dto = OcorrenciaMapper.domainToOutDto(ocorrencia, getEstacaoUseCase.execute(ocorrencia.getIdEstacao()), getCameraUseCase.execute(ocorrencia.getIdCamera()), getCcoUseCase.execute(getEstacaoUseCase.execute(ocorrencia.getIdEstacao()).getId()));
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<OcorrenciaLazyOutDto>> listar(@RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                                                             @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                                             @RequestParam(name = "direction", required = false, defaultValue = "DESC") Sort.Direction direction){

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, "id"));
        Page<Ocorrencia> domainPage = this.getOcorrenciasUseCase.execute(pageable);
        Page<OcorrenciaLazyOutDto> dtoPage = domainPage.map(ApiMapper::ocorrenciaToLazyDto);
        return ResponseEntity.ok(dtoPage);
    }

    @GetMapping("/curadoria")
    public ResponseEntity<Page<OcorrenciaLazyOutDto>> listarOcorrenciasCuradoria(@RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                                                                                 @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                                                                 @RequestParam(name = "direction", required = false, defaultValue = "DESC") Sort.Direction direction){

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, "id"));
        Page<Ocorrencia> domainPage = this.getOcorrenciasAtivoFalseUseCase.execute(pageable);
        Page<OcorrenciaLazyOutDto> dtoPage = domainPage.map(ApiMapper::ocorrenciaToLazyDto);
        return ResponseEntity.ok(dtoPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OcorrenciaOutDetailDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid OcorrenciaUpdateDto dados){

        Ocorrencia ocorrencia = updateOcorrenciaUseCase.execute(id, OcorrenciaMapper.updateDtoToDomain(dados));
        OcorrenciaOutDetailDto dto = OcorrenciaMapper.domainToOutDto(ocorrencia, getEstacaoUseCase.execute(ocorrencia.getIdEstacao()), getCameraUseCase.execute(ocorrencia.getIdCamera()), getCcoUseCase.execute(getEstacaoUseCase.execute(ocorrencia.getIdEstacao()).getId()));
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        deleteOcorrenciaUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OcorrenciaOutDetailDto> ativar(@PathVariable("id") Long id){
        patchOcorrenciaAtivoUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
