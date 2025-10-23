package com.sentinel.api.application.service;

import com.sentinel.api.domain.model.Camera;
import com.sentinel.api.domain.repository.CameraRepository;

public class CameraService {

    private final CameraRepository cameraRepository;

    public CameraService(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }


    public Camera findById(Long id) {
        return cameraRepository.findById(id);
    }
}
