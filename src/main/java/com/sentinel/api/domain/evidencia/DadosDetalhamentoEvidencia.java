package com.sentinel.api.domain.evidencia;

import com.sentinel.api.domain.ocorrencia.DadosDetalhamentoOcorrencia;

public record DadosDetalhamentoEvidencia(
        Long id,
        String key,
        DadosDetalhamentoOcorrencia dadosDetalhamentoOcorrencia
) {
    public DadosDetalhamentoEvidencia(Evidencia evidencia){
        this(
                evidencia.getId(),
                evidencia.getKey(), 
                evidencia.getOcorrencia() != null ? new DadosDetalhamentoOcorrencia(evidencia.getOcorrencia()) : null
        );
    }
}
