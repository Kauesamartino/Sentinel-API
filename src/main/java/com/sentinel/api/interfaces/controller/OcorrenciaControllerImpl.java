package com.sentinel.api.interfaces.controller;

import com.sentinel.api.application.usecase.camera.GetCameraUseCase;
import com.sentinel.api.application.usecase.cco.GetCcoUseCase;
import com.sentinel.api.application.usecase.estacao.GetEstacaoUseCase;
import com.sentinel.api.application.usecase.ocorrencia.*;
import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaUpdateDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaInDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaOutDetailDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaLazyOutDto;
import com.sentinel.api.interfaces.mapper.ApiMapper;
import com.sentinel.api.interfaces.mapper.OcorrenciaMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

public final class OcorrenciaControllerImpl implements OcorrenciaController {

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

    public OcorrenciaControllerImpl(CreateOcorrenciaUseCase createOcorrenciaUseCase, UpdateOcorrenciaUseCase updateOcorrenciaUseCase, DeleteOcorrenciaUseCase deleteOcorrenciaUseCase, GetOcorrenciasUseCase getOcorrenciasUseCase, GetOcorrenciaUseCase getOcorrenciaUseCase, GetOcorrenciasRelatorioUseCase getOcorrenciasRelatorioUseCase, GetOcorrenciasAtivoFalseUseCase getOcorrenciasAtivoFalseUseCase, PatchOcorrenciaAtivoUseCase patchOcorrenciaAtivoUseCase, GetCameraUseCase getCameraUseCase, GetEstacaoUseCase getEstacaoUseCase, GetCcoUseCase getCcoUseCase) {
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



    @Override
    public OcorrenciaOutDetailDto cadastrar(OcorrenciaInDto ocorrenciaInDto) {
        Ocorrencia ocorrencia = OcorrenciaMapper.inDtoToDomain(ocorrenciaInDto);
        Ocorrencia createdOcorrencia =  createOcorrenciaUseCase.execute(ocorrencia);
        return OcorrenciaMapper.domainToOutDto(createdOcorrencia, getEstacaoUseCase.execute(ocorrencia.getIdEstacao()), getCameraUseCase.execute(ocorrencia.getIdCamera()), getCcoUseCase.execute(getEstacaoUseCase.execute(ocorrencia.getIdEstacao()).getId()));
    }

    @Override
    public Page<OcorrenciaLazyOutDto> listarOcorrenciasDeUmRelatorio(Long id, Integer pageSize, Integer pageNumber, Sort.Direction direction){
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, "id"));
        Page<Ocorrencia> domainPage = getOcorrenciasRelatorioUseCase.execute(id, pageable);
        return domainPage.map(ApiMapper::ocorrenciaToLazyDto);
    }

    @Override
    public OcorrenciaOutDetailDto detalhar(Long id){
        Ocorrencia ocorrencia = getOcorrenciaUseCase.execute(id);
        return OcorrenciaMapper.domainToOutDto(ocorrencia, getEstacaoUseCase.execute(ocorrencia.getIdEstacao()), getCameraUseCase.execute(ocorrencia.getIdCamera()), getCcoUseCase.execute(getEstacaoUseCase.execute(ocorrencia.getIdEstacao()).getId()));
    }

    @Override
    public Page<OcorrenciaLazyOutDto> listar(Integer pageSize, Integer pageNumber, Sort.Direction direction){
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, "id"));
        Page<Ocorrencia> domainPage = this.getOcorrenciasUseCase.execute(pageable);

        return domainPage.map(ApiMapper::ocorrenciaToLazyDto);
    }

    @Override
    public Page<OcorrenciaLazyOutDto> listarOcorrenciasCuradoria(Integer pageSize, Integer pageNumber, Sort.Direction direction) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, "id"));
        Page<Ocorrencia> domainPage = this.getOcorrenciasAtivoFalseUseCase.execute(pageable);
        return domainPage.map(ApiMapper::ocorrenciaToLazyDto);
    }

    @Override
    public OcorrenciaOutDetailDto atualizar(Long id, OcorrenciaUpdateDto dados){
        Ocorrencia ocorrencia = updateOcorrenciaUseCase.execute(id, OcorrenciaMapper.updateDtoToDomain(dados));
        return OcorrenciaMapper.domainToOutDto(ocorrencia, getEstacaoUseCase.execute(ocorrencia.getIdEstacao()), getCameraUseCase.execute(ocorrencia.getIdCamera()), getCcoUseCase.execute(getEstacaoUseCase.execute(ocorrencia.getIdEstacao()).getId()));
    }

    @Override
    public void excluir(@PathVariable("id") Long id){
        deleteOcorrenciaUseCase.execute(id);
    }

    @PatchMapping("/{id}")
    public void ativar(@PathVariable("id") Long id){
        patchOcorrenciaAtivoUseCase.execute(id);
    }
}
