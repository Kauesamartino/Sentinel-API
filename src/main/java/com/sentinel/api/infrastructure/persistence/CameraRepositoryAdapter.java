package com.sentinel.api.infrastructure.persistence;

import com.sentinel.api.domain.model.Camera;
import com.sentinel.api.domain.repository.CameraRepository;
import com.sentinel.api.infrastructure.entity.JpaCameraEntity;
import com.sentinel.api.infrastructure.repository.JpaCameraRepository;
import com.sentinel.api.interfaces.mapper.CameraMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public final class CameraRepositoryAdapter implements CameraRepository {

    private final JpaCameraRepository jpaCameraRepository;

    @Override
    public Camera findById(Long id) {
        JpaCameraEntity entity = jpaCameraRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Camera não encontrada"));
        return CameraMapper.entityToDomain(entity);
    }
}
