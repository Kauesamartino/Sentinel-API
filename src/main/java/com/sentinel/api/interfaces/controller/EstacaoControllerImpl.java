package com.sentinel.api.interfaces.controller;

import com.sentinel.api.application.usecase.cco.GetCcoUseCase;
import com.sentinel.api.application.usecase.estacao.CreateEstacaoUseCase;
import com.sentinel.api.application.usecase.estacao.DeleteEstacaoUseCase;
import com.sentinel.api.application.usecase.estacao.GetEstacaoUseCase;
import com.sentinel.api.application.usecase.estacao.GetEstacoesUseCase;
import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.interfaces.dto.estacao.EstacaoInDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoOutDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoLazyOutDto;
import com.sentinel.api.interfaces.mapper.ApiMapper;
import com.sentinel.api.interfaces.mapper.EstacaoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

public final class EstacaoControllerImpl implements  EstacaoController {

    private final CreateEstacaoUseCase createEstacaoUseCase;
    private final GetEstacoesUseCase getEstacoesUseCase;
    private final GetEstacaoUseCase getEstacaoUseCase;
    private final DeleteEstacaoUseCase deleteEstacaoUseCase;
    private final GetCcoUseCase getCcoUseCase;

    public EstacaoControllerImpl(CreateEstacaoUseCase createEstacaoUseCase, GetEstacoesUseCase getEstacoesUseCase, GetEstacaoUseCase getEstacaoUseCase, DeleteEstacaoUseCase deleteEstacaoUseCase, GetCcoUseCase getCcoUseCase) {
        this.createEstacaoUseCase = createEstacaoUseCase;
        this.getEstacoesUseCase = getEstacoesUseCase;
        this.getEstacaoUseCase = getEstacaoUseCase;
        this.deleteEstacaoUseCase = deleteEstacaoUseCase;
        this.getCcoUseCase = getCcoUseCase;
    }


    @Override
    public EstacaoOutDto cadastrar(EstacaoInDto estacaoInDto) {
        Estacao estacao = EstacaoMapper.inDtoToDomain(estacaoInDto);
        Estacao createdEstacao = createEstacaoUseCase.execute(estacao);
        return EstacaoMapper.domainToOutDto(createdEstacao, getCcoUseCase.execute(createdEstacao.getIdCco()));
    }

    @Override
    public Page<EstacaoLazyOutDto> listar(Integer pageSize, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Estacao> domainPage = getEstacoesUseCase.execute(pageable);
        return domainPage.map(ApiMapper::estacaoToLazyDto);
    }

    @Override
    public EstacaoOutDto detalhar(Long id) {
        Estacao estacao = getEstacaoUseCase.execute(id);
        return EstacaoMapper.domainToOutDto(estacao, getCcoUseCase.execute(estacao.getIdCco()));
    }

    @Override
    public void deletar(Long id) {
        deleteEstacaoUseCase.execute(id);
    }

}
