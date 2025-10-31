package com.sentinel.api.domain.repository;

import com.sentinel.api.domain.model.Camera;

public interface CameraRepository {
    Camera findById(Long id);
}
