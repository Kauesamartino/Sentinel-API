package com.sentinel.api.interfaces.mapper;

import com.sentinel.api.domain.model.Camera;
import com.sentinel.api.infrastructure.entity.JpaCameraEntity;
import com.sentinel.api.interfaces.dto.camera.CameraOutDto;

public final class CameraMapper {

    public static Camera entityToDomain(JpaCameraEntity entity) {
        return new Camera(
                entity.getCodigo(),
                entity.getModelo(),
                entity.getJpaCarroEntity().getId()
        );
    }

    public static CameraOutDto domainToOutDto(Camera camera) {
        return new CameraOutDto(
                camera.getCodigo()
        );
    }
}
