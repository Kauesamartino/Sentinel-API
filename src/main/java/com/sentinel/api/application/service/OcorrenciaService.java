package com.sentinel.api.application.service;

import com.sentinel.api.infrastructure.entity.Ocorrencia;
import com.sentinel.api.infrastructure.repository.EstacaoRepository;
import com.sentinel.api.infrastructure.repository.OcorrenciaRepository;
import com.sentinel.api.interfaces.dto.ocorrencia.DadosCadastroOcorrencia;
import com.sentinel.api.interfaces.dto.ocorrencia.DadosDetalhamentoOcorrencia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class OcorrenciaService {

    private final OcorrenciaRepository ocorrenciaRepository;
    private final EstacaoRepository estacaoRepository;
    private final Random random = new Random();

    public DadosDetalhamentoOcorrencia cadastrar(DadosCadastroOcorrencia dados) {
        var idEstacao = (dados.idEstacao() != null)
                ? dados.idEstacao()
                : (long) (random.nextInt(5) + 1);

        var estacao = estacaoRepository.getReferenceById(idEstacao);

        Ocorrencia ocorrencia = new Ocorrencia(dados, estacao);
        ocorrenciaRepository.save(ocorrencia);
        return new DadosDetalhamentoOcorrencia(ocorrencia);
    }

}
