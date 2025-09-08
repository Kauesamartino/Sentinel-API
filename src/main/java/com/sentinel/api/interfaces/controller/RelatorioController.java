package com.sentinel.api.interfaces.controller;

import com.sentinel.api.infrastructure.entity.Relatorio;
import com.sentinel.api.infrastructure.repository.RelatorioRepository;
import com.sentinel.api.interfaces.dto.relatorio.DadosCadastroRelatorio;
import com.sentinel.api.interfaces.dto.relatorio.DadosDetalhamentoRelatorio;
import com.sentinel.api.interfaces.dto.relatorio.DadosListagemRelatorios;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("relatorios")
@RequiredArgsConstructor
public class RelatorioController {

    private final RelatorioRepository relatorioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastroRelatorio dados, UriComponentsBuilder uriBuilder){
        var relatorio = new Relatorio(dados);
        relatorioRepository.save(relatorio);
        var uri = uriBuilder.path("/relatorios/{id}").buildAndExpand(relatorio.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoRelatorio(relatorio));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemRelatorios>> listar(@PageableDefault(size = 10) Pageable pageable) {
        var page = relatorioRepository.findAll(pageable).map(DadosListagemRelatorios::new);
        return ResponseEntity.ok(page);
    }
}
