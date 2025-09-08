package com.sentinel.api.application.usecases.ocorrencia.ports;

import com.sentinel.api.domain.enums.Status;
import com.sentinel.api.domain.enums.TipoOcorrencia;

public record UpdateOcorrenciaInput(String titulo,
                                    String description,
                                    Status status,
                                    TipoOcorrencia tipoOcorrencia) {
}
