package com.sentinel.api.controller;

import com.sentinel.api.domain.evidencia.DadosCadastroEvidencia;
import com.sentinel.api.domain.evidencia.DadosDetalhamentoEvidencia;
import com.sentinel.api.domain.evidencia.Evidencia;
import com.sentinel.api.domain.evidencia.EvidenciaRepository;
import com.sentinel.api.domain.ocorrencia.OcorrenciaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("evidencias")
@RequiredArgsConstructor
public class EvidenciaController {
    
    EvidenciaRepository evidenciaRepository;
    OcorrenciaRepository ocorrenciaRepository;
    
    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastroEvidencia dados, UriComponentsBuilder uriBuilder) {
        var ocorrencia = ocorrenciaRepository.getReferenceById(dados.idOcorrencia());
        var evidencia = new Evidencia(dados, ocorrencia);
        evidenciaRepository.save(evidencia);
        var uri = uriBuilder.path("/evidencias/{id}").buildAndExpand(ocorrencia.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEvidencia(evidencia));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhar(@PathVariable Long id) {
        var evidencia =  evidenciaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoEvidencia(evidencia));
    }
}
