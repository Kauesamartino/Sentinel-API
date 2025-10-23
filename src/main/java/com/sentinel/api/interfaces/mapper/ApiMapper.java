package com.sentinel.api.interfaces.mapper;

import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.interfaces.dto.estacao.EstacaoLazyOutDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaLazyOutDto;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioLazyOutDto;

public final class ApiMapper {
    public static OcorrenciaLazyOutDto ocorrenciaToLazyDto(Ocorrencia ocorrencia) {
        return new OcorrenciaLazyOutDto(ocorrencia);
    }

    public static EstacaoLazyOutDto estacaoToLazyDto(Estacao estacao) {
        return new EstacaoLazyOutDto(estacao);
    }

    public static RelatorioLazyOutDto domainToLazyDto(Relatorio relatorio) {
        return new RelatorioLazyOutDto(relatorio);
    }
}
