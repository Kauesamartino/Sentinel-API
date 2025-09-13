package com.sentinel.api.interfaces.controller;

import com.sentinel.api.application.usecase.relatorio.CreateRelatorioUseCaseImpl;
import com.sentinel.api.application.usecase.relatorio.GetRelatoriosUseCaseImpl;
import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioInDto;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioOutDto;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioLazyOutDto;
import com.sentinel.api.interfaces.mapper.ApiMapper;
import com.sentinel.api.interfaces.mapper.RelatorioMapper;
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
@RequestMapping("relatorios")
@RequiredArgsConstructor
public class RelatorioController {

    private final RelatorioMapper mapper;
    private final CreateRelatorioUseCaseImpl createRelatorioUseCaseImpl;
    private final ApiMapper apiMapper;
    private final GetRelatoriosUseCaseImpl getRelatoriosUseCaseImpl;

    @PostMapping
    public ResponseEntity<RelatorioOutDto> cadastrar(@RequestBody @Valid RelatorioInDto dados, UriComponentsBuilder uriBuilder){

        Relatorio relatorio = mapper.inDtoToDomain(dados);
        Relatorio createdRelatorio = createRelatorioUseCaseImpl.execute(relatorio);
        RelatorioOutDto dto = mapper.domainToOutDto(createdRelatorio);
        URI uri = uriBuilder.path("/relatorios/{id}").buildAndExpand(relatorio.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<RelatorioLazyOutDto>> listar(@RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                                            @RequestParam(name = "sizePage", required = false, defaultValue = "20") Integer pageSize,
                                                            @RequestParam(name = "direction", required = false, defaultValue = "DESC")Sort.Direction direction) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, "id"));
        Page<Relatorio> domainPage = getRelatoriosUseCaseImpl.execute(pageable);
        Page<RelatorioLazyOutDto> dto = domainPage.map(apiMapper::domainToLazyDto);
        return ResponseEntity.ok(dto);
    }
}
