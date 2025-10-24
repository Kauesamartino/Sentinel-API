package com.sentinel.api.interfaces.controller;

import com.sentinel.api.application.usecase.cco.CreateCcoUseCase;
import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.interfaces.dto.cco.CcoInDto;
import com.sentinel.api.interfaces.dto.cco.CcoOutDto;
import com.sentinel.api.interfaces.mapper.CentroControleOperacoesMapper;

public final class CentroControleOperacoesControllerImpl implements  CentroControleOperacoesController {

    private final CreateCcoUseCase createCcoUseCase;

    public CentroControleOperacoesControllerImpl(CreateCcoUseCase createCcoUseCase) {
        this.createCcoUseCase = createCcoUseCase;
    }


    public CcoOutDto cadastrar(CcoInDto dados){
        CentroControleOperacoes createdCco = createCcoUseCase.execute(CentroControleOperacoesMapper.inDtoToDomain(dados));
        return CentroControleOperacoesMapper.domainToOutDto(createdCco);
    }

}
