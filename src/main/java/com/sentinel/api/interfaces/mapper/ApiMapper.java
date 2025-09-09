package com.sentinel.api.interfaces.mapper;

import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.interfaces.dto.estacao.EstacaoLazyOutDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaLazyOutDto;
import com.sentinel.api.interfaces.dto.relatorio.DadosListagemRelatorios;
import org.springframework.stereotype.Component;

@Component
public class ApiMapper {
    public OcorrenciaLazyOutDto ocorrenciaToLazyDto(Ocorrencia ocorrencia) {
        return new OcorrenciaLazyOutDto(ocorrencia);
    }

    public EstacaoLazyOutDto estacaoToLazyDto(Estacao estacao) {
        return new EstacaoLazyOutDto(estacao);
    }

    public DadosListagemRelatorios domainToLazyDto(Relatorio relatorio) {
        return new DadosListagemRelatorios(relatorio);
    }
}
