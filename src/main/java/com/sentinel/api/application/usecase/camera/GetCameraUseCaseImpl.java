package com.sentinel.api.application.usecase.camera;

import com.sentinel.api.domain.model.Camera;
import com.sentinel.api.domain.repository.CameraRepository;

public final class GetCameraUseCaseImpl implements GetCameraUseCase {

    private final CameraRepository cameraRepository;

    public GetCameraUseCaseImpl(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    @Override
    public Camera execute(Long id) {
        return cameraRepository.findById(id);
    }
}
