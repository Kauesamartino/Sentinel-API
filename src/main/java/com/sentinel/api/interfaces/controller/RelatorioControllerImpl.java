package com.sentinel.api.interfaces.controller;

import com.sentinel.api.application.usecase.relatorio.CreateRelatorioUseCase;
import com.sentinel.api.application.usecase.relatorio.GetRelatoriosUseCase;
import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioInDto;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioOutDto;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioLazyOutDto;
import com.sentinel.api.interfaces.mapper.ApiMapper;
import com.sentinel.api.interfaces.mapper.RelatorioMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

public final class RelatorioControllerImpl implements  RelatorioController {

    private final CreateRelatorioUseCase createRelatorioUseCase;
    private final GetRelatoriosUseCase getRelatoriosUseCase;

    public RelatorioControllerImpl(CreateRelatorioUseCase createRelatorioUseCase, GetRelatoriosUseCase getRelatoriosUseCase) {
        this.createRelatorioUseCase = createRelatorioUseCase;
        this.getRelatoriosUseCase = getRelatoriosUseCase;
    }

    @Override
    public RelatorioOutDto cadastrar(RelatorioInDto relatorioInDto) {
        Relatorio relatorio = RelatorioMapper.inDtoToDomain(relatorioInDto);
        Relatorio createdRelatorio = createRelatorioUseCase.execute(relatorio);

        return RelatorioMapper.domainToOutDto(createdRelatorio);
    }

    @Override
    public Page<RelatorioLazyOutDto> listar(Integer pageSize, Integer pageNumber, Sort.Direction direction){
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, "id"));
        Page<Relatorio> domainPage = getRelatoriosUseCase.execute(pageable);

        return domainPage.map(ApiMapper::domainToLazyDto);
    }
}
