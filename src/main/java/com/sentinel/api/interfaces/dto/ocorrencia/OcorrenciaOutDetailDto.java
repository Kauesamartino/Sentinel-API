package com.sentinel.api.interfaces.dto.ocorrencia;

import com.sentinel.api.domain.entity.Ocorrencia;
import com.sentinel.api.domain.enums.Severidade;
import com.sentinel.api.domain.enums.Status;
import com.sentinel.api.domain.enums.TipoOcorrencia;
import com.sentinel.api.interfaces.dto.estacao.DadosDetalhamentoEstacao;

import java.time.LocalDateTime;

public record OcorrenciaOutDetailDto(
        Long id,
        String titulo,
        String descricao,
        LocalDateTime data,
        Severidade severidade,
        Status status,
        TipoOcorrencia tipoOcorrencia,
        DadosDetalhamentoEstacao dadosDetalhamentoEstacao,
        Boolean ativo
) {
    public OcorrenciaOutDetailDto(Ocorrencia ocorrencia){
        this(
                ocorrencia.getId(), 
                ocorrencia.getTitulo(), 
                ocorrencia.getDescricao(), 
                ocorrencia.getData(),
                ocorrencia.getSeveridade(),
                ocorrencia.getStatus(),
                ocorrencia.getTipoOcorrencia(),
                ocorrencia.getEstacao() != null ? new DadosDetalhamentoEstacao(ocorrencia.getEstacao()) : null, ocorrencia.getAtivo());
    }
}
