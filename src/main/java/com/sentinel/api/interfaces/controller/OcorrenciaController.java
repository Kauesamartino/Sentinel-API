package com.sentinel.api.interfaces.controller;

import com.sentinel.api.domain.ocorrencia.*;
import com.sentinel.api.domain.relatorio.RelatorioRepository;
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


@RestController
@RequestMapping("ocorrencias")
@RequiredArgsConstructor
public class OcorrenciaController {

    private final RelatorioRepository relatorioRepository;
    private final OcorrenciaRepository ocorrenciaRepository;
    private final OcorrenciaService ocorrenciaService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastroOcorrencia dados, UriComponentsBuilder uriBuilder){
        var dto = ocorrenciaService.cadastrar(dados);
        var uri = uriBuilder.path("/ocorrencias/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
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
    public ResponseEntity<?> detalhar(@PathVariable Long id){
        var ocorrencia = ocorrenciaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoOcorrencia(ocorrencia));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemOcorrencias>> listar(@PageableDefault(size = 20, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable){
        var page = ocorrenciaRepository.findAllByAtivoTrue(pageable).map(DadosListagemOcorrencias::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@RequestBody @Valid DadosAtualizacaoOcorrencia dados){
        var ocorrencia = ocorrenciaRepository.getReferenceById(dados.id());
        ocorrencia.atualizarInformacoes(dados);
        return ResponseEntity.ok(new  DadosDetalhamentoOcorrencia(ocorrencia));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id){
        var ocorrencia = ocorrenciaRepository.getReferenceById(id);
        ocorrenciaRepository.deleteById(ocorrencia.getId());
        return  ResponseEntity.noContent().build();
    }
}
