package com.sentinel.api.interfaces.controller;

import com.sentinel.api.application.usecases.relatorio.CreateRelatorioUseCase;
import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.infrastructure.entity.JpaRelatorioEntity;
import com.sentinel.api.infrastructure.repository.JpaRelatorioRepository;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioInDto;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioOutDto;
import com.sentinel.api.interfaces.dto.relatorio.DadosListagemRelatorios;
import com.sentinel.api.interfaces.mapper.RelatorioMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("relatorios")
@RequiredArgsConstructor
public class RelatorioController {

    private final JpaRelatorioRepository jpaRelatorioRepository;
    private final RelatorioMapper mapper;
    private final CreateRelatorioUseCase createRelatorioUseCase;

    @PostMapping
    @Transactional
    public ResponseEntity<RelatorioOutDto> cadastrar(@RequestBody @Valid RelatorioInDto dados, UriComponentsBuilder uriBuilder){

        Relatorio relatorio = mapper.inDtoToDomain(dados);
        Relatorio createdRelatorio = createRelatorioUseCase.execute(relatorio);
        RelatorioOutDto dto = mapper.domainToOutDto(createdRelatorio);
        URI uri = uriBuilder.path("/relatorios/{id}").buildAndExpand(relatorio.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemRelatorios>> listar(@PageableDefault(size = 10) Pageable pageable) {
        var page = jpaRelatorioRepository.findAll(pageable).map(DadosListagemRelatorios::new);
        return ResponseEntity.ok(page);
    }
}
