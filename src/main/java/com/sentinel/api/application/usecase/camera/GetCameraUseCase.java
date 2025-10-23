package com.sentinel.api.application.usecase.camera;

import com.sentinel.api.domain.model.Camera;

public interface GetCameraUseCase {
    Camera execute(Long id);
}
