package com.sentinel.api.interfaces.mapper;

import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.infrastructure.entity.JpaRelatorioEntity;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioInDto;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioOutDto;

public final class RelatorioMapper {
    public static Relatorio inDtoToDomain(RelatorioInDto dados) {
        return new Relatorio(
                dados.titulo(),
                dados.descricao(),
                dados.tipoOcorrencia(),
                dados.dataInicio(),
                dados.dataFim()
        );
    }

    public static RelatorioOutDto domainToOutDto(Relatorio createdRelatorio) {
        return new RelatorioOutDto(
                createdRelatorio.getId(),
                createdRelatorio.getTitulo(),
                createdRelatorio.getDescricao(),
                createdRelatorio.getTipoOcorrencia(),
                createdRelatorio.getDataInicio(),
                createdRelatorio.getDataFim()
        );
    }

    public static JpaRelatorioEntity domainToJpaEntity(Relatorio relatorio) {
        return new JpaRelatorioEntity(
                relatorio.getId(),
                relatorio.getTitulo(),
                relatorio.getDescricao(),
                relatorio.getTipoOcorrencia(),
                relatorio.getDataInicio(),
                relatorio.getDataFim()
        );
    }

    public static Relatorio jpaEntityToDomain(JpaRelatorioEntity savedEntity) {
        return new Relatorio(
                savedEntity.getId(),
                savedEntity.getTitulo(),
                savedEntity.getDescricao(),
                savedEntity.getTipoOcorrencia(),
                savedEntity.getDataInicio(),
                savedEntity.getDataFim()
        );
    }
}
