package com.sentinel.api.interfaces.mapper;

import com.sentinel.api.domain.model.Camera;
import com.sentinel.api.domain.model.CentroControleOperacoes;
import com.sentinel.api.domain.model.Estacao;
import com.sentinel.api.domain.model.Ocorrencia;
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

public final class OcorrenciaMapper {

    public static Ocorrencia inDtoToDomain(@Valid OcorrenciaInDto dados) {
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

    public static OcorrenciaOutDetailDto domainToOutDto(Ocorrencia ocorrencia, Estacao estacao, Camera camera, CentroControleOperacoes cco) {
        CcoOutDto ccoOutDto = new CcoOutDto(cco.getId(), cco.getName());

        EstacaoOutDto estacaoOutDto = new EstacaoOutDto(
                estacao.getId(),
                estacao.getNome(),
                estacao.getLinha(),
                ccoOutDto,
                estacao.getEndereco()
        );

        CameraOutDto cameraOutDto = new CameraOutDto(camera.getCodigo());

        return new OcorrenciaOutDetailDto(
                ocorrencia.getId(),
                ocorrencia.getTitulo(),
                ocorrencia.getDescricao(),
                ocorrencia.getData(),
                ocorrencia.getSeveridade(),
                ocorrencia.getStatus(),
                ocorrencia.getTipoOcorrencia(),
                estacaoOutDto,
                cameraOutDto,
                ocorrencia.getAtivo()
        );
    }

    public static Ocorrencia updateDtoToDomain(OcorrenciaUpdateDto dados) {
        return new Ocorrencia(dados.titulo(), dados.descricao(), dados.status(), dados.tipoOcorrencia(), dados.severidade(), dados.ativo());
    }

    public static Ocorrencia jpaEntityToDomain(JpaOcorrenciaEntity entity) {
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

    public static JpaOcorrenciaEntity domainToJpa(Ocorrencia ocorrencia, JpaEstacaoEntity estacaoEntity, JpaCameraEntity cameraEntity) {
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
