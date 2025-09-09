package com.sentinel.api.interfaces.mapper;

import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.infrastructure.entity.JpaRelatorioEntity;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioInDto;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioOutDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class RelatorioMapper {
    public Relatorio inDtoToDomain(@Valid RelatorioInDto dados) {
        return new Relatorio(dados);
    }

    public RelatorioOutDto domainToOutDto(Relatorio createdRelatorio) {
        return new RelatorioOutDto(createdRelatorio);
    }

    public JpaRelatorioEntity domainToJpaEntity(Relatorio relatorio) {
        return new JpaRelatorioEntity(relatorio);
    }

    public Relatorio jpaEntityToDomain(JpaRelatorioEntity savedEntity) {
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
