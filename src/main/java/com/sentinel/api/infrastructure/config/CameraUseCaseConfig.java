package com.sentinel.api.infrastructure.config;

import com.sentinel.api.application.usecase.camera.GetCameraUseCase;
import com.sentinel.api.application.usecase.camera.GetCameraUseCaseImpl;
import com.sentinel.api.domain.repository.CameraRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CameraUseCaseConfig {

    private final CameraRepository cameraRepository;

    public CameraUseCaseConfig(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    @Bean
    public GetCameraUseCase getCameraUseCase(){
        return new GetCameraUseCaseImpl(cameraRepository);
    }
}
