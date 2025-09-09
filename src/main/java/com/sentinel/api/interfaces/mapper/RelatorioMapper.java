package com.sentinel.api.interfaces.mapper;

import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioInDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class RelatorioMapper {
    public Relatorio inDtoToDomain(@Valid RelatorioInDto dados) {
        return new Relatorio(dados);
    }
}
