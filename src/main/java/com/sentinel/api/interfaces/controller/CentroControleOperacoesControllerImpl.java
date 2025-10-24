package com.sentinel.api.interfaces.controller;

import com.sentinel.api.application.usecase.cco.CreateCcoUseCaseImpl;
import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.interfaces.dto.cco.CcoInDto;
import com.sentinel.api.interfaces.dto.cco.CcoOutDto;
import com.sentinel.api.interfaces.mapper.CentroControleOperacoesMapper;

public final class CentroControleOperacoesControllerImpl implements  CentroControleOperacoesController {

    private final CreateCcoUseCaseImpl  createCcoUseCaseImpl;

    public CentroControleOperacoesControllerImpl(CreateCcoUseCaseImpl createCcoUseCaseImpl) {
        this.createCcoUseCaseImpl = createCcoUseCaseImpl;
    }

    public CcoOutDto cadastrar(CcoInDto dados){
        CentroControleOperacoes createdCco = createCcoUseCaseImpl.execute(CentroControleOperacoesMapper.inDtoToDomain(dados));
        return CentroControleOperacoesMapper.domainToOutDto(createdCco);
    }

}
