package com.sentinel.api.application.usecases.ocorrencia;

import com.sentinel.api.domain.enums.Severidade;
import com.sentinel.api.domain.enums.TipoOcorrencia;

public record CreateOcorrenciaInput(String titulo,
                                    String descricao,
                                    Severidade severidade,
                                    Long idEstacao,
                                    TipoOcorrencia tipoOcorrencia,
                                    Boolean ativo
) {

}
