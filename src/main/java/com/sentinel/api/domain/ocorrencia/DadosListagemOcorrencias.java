package com.sentinel.api.domain.ocorrencia;

import com.sentinel.api.domain.estacao.DadosDetalhamentoEstacao;
import com.sentinel.api.domain.estacao.DadosDetalhamentoEstacaoListagemMedicos;

import java.time.LocalDateTime;

public record DadosListagemOcorrencias(
        Long id,
        String titulo,
        TipoOcorrencia tipoOcorrencia,
        LocalDateTime data,
        Severidade severidade,
        Status status,
        DadosDetalhamentoEstacaoListagemMedicos dadosDetalhamentoEstacaoListagemMedicos
) {
    public DadosListagemOcorrencias(Ocorrencia ocorrencia){
        this(
                ocorrencia.getId(),
                ocorrencia.getTitulo(),
                ocorrencia.getTipoOcorrencia(),
                ocorrencia.getData(),
                ocorrencia.getSeveridade(),
                ocorrencia.getStatus(),
                ocorrencia.getEstacao() != null ? new DadosDetalhamentoEstacaoListagemMedicos(ocorrencia.getEstacao()) : null
        );
    }

}
