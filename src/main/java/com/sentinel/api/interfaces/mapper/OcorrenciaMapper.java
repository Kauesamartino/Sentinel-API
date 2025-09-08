package com.sentinel.api.interfaces.mapper;

import com.sentinel.api.application.usecases.ocorrencia.ports.CreateOcorrenciaInput;
import com.sentinel.api.application.usecases.ocorrencia.ports.UpdateOcorrenciaInput;
import com.sentinel.api.domain.entity.Ocorrencia;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaInDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaOutDetailDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaUpdateDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class OcorrenciaMapper {

    public CreateOcorrenciaInput inDtoToInput(@Valid OcorrenciaInDto dados) {
        return new CreateOcorrenciaInput(dados.titulo(), dados.descricao(), dados.severidade(), dados.idEstacao(), dados.tipoOcorrencia(), dados.ativo());
    }

    public OcorrenciaOutDetailDto entityToOutDetailDto(Ocorrencia createdOcorrencia) {
        return new OcorrenciaOutDetailDto(createdOcorrencia);
    }

    public UpdateOcorrenciaInput updateDtoToInput(@Valid OcorrenciaUpdateDto dados) {
        return new UpdateOcorrenciaInput(dados.titulo(), dados.descricao(), dados.status(), dados.tipoOcorrencia());
    }
}
