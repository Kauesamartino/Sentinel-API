package com.sentinel.api.interfaces.mapper;

import com.sentinel.api.domain.model.Camera;
import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.model.Ocorrencia;
import com.sentinel.api.domain.repository.CentroControleOperacoesRepository;
import com.sentinel.api.domain.repository.EstacaoRepository;
import com.sentinel.api.infrastructure.entity.JpaCameraEntity;
import com.sentinel.api.infrastructure.entity.JpaEstacaoEntity;
import com.sentinel.api.infrastructure.entity.JpaOcorrenciaEntity;
import com.sentinel.api.interfaces.dto.camera.CameraOutDto;
import com.sentinel.api.interfaces.dto.cco.CcoOutDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoOutDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaInDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaOutDetailDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OcorrenciaMapper {
    private final EstacaoRepository estacaoRepository;
    private final CentroControleOperacoesRepository centroControleOperacoesRepository;

    public Ocorrencia inDtoToDomain(@Valid OcorrenciaInDto dados) {
        return new Ocorrencia(
                dados.titulo(),
                dados.descricao(),
                dados.severidade(),
                dados.tipoOcorrencia(),
                dados.idEstacao(),
                dados.idCamera(),
                dados.ativo()
        );
    }

    public OcorrenciaOutDetailDto domainToOutDto(Ocorrencia ocorrencia, Camera camera) {
        EstacaoOutDto estacaoOutDto = null;
        if (ocorrencia.getIdEstacao() != null) {
            Estacao estacao = estacaoRepository.findById(ocorrencia.getIdEstacao());
            CcoOutDto ccoOutDto = null;
            if (estacao.getIdCco() != null) {
                CentroControleOperacoes centroControleOperacoes = centroControleOperacoesRepository.findById(estacao.getIdCco());
                ccoOutDto = new CcoOutDto(
                        centroControleOperacoes.getId(),
                        centroControleOperacoes.getName()
                );
            }
            estacaoOutDto = new EstacaoOutDto(estacao, ccoOutDto);
        }

        CameraOutDto cameraOutDto = new CameraOutDto(camera.getCodigo());
        return new OcorrenciaOutDetailDto(ocorrencia, estacaoOutDto, cameraOutDto);
    }

    public Ocorrencia updateDtoToDomain(OcorrenciaUpdateDto dados) {
        return new Ocorrencia(dados.titulo(), dados.descricao(), dados.status(), dados.tipoOcorrencia(), dados.severidade(), dados.ativo());
    }

    public Ocorrencia jpaEntityToDomain(JpaOcorrenciaEntity entity) {
        return new Ocorrencia(
                entity.getId(),
                entity.getTitulo(),
                entity.getDescricao(),
                entity.getData(),
                entity.getSeveridade(),
                entity.getStatus(),
                entity.getTipoOcorrencia(),
                entity.getJpaEstacaoEntity().getId(),
                entity.getJpaCameraEntity().getId(),
                entity.getAtivo());
    }

    public JpaOcorrenciaEntity domainToJpa(Ocorrencia ocorrencia, JpaEstacaoEntity estacaoEntity, JpaCameraEntity cameraEntity) {
        return new JpaOcorrenciaEntity(
                ocorrencia.getTitulo(),
                ocorrencia.getDescricao(),
                ocorrencia.getData(),
                ocorrencia.getSeveridade(),
                ocorrencia.getStatus(),
                ocorrencia.getTipoOcorrencia(),
                estacaoEntity,
                cameraEntity,
                ocorrencia.getAtivo()
        );
    }
}
