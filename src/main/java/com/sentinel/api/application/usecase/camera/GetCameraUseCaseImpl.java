package com.sentinel.api.application.usecase.camera;

import com.sentinel.api.application.service.CameraService;
import com.sentinel.api.domain.model.Camera;
import com.sentinel.api.domain.repository.CameraRepository;
import com.sentinel.api.domain.usecase.camera.GetCameraUseCase;

public class GetCameraUseCaseImpl implements GetCameraUseCase {

    private final CameraService cameraService;

    public GetCameraUseCaseImpl(CameraService cameraService) {
        this.cameraService = cameraService;
    }

    @Override
    public Camera execute(Long id) {
        return cameraService.findById(id);
    }
}
