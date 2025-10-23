package com.sentinel.api.infrastructure.config;

import com.sentinel.api.application.usecase.camera.GetCameraUseCase;
import com.sentinel.api.application.usecase.cco.GetCcoUseCase;
import com.sentinel.api.application.usecase.estacao.GetEstacaoUseCase;
import com.sentinel.api.application.usecase.ocorrencia.*;
import com.sentinel.api.interfaces.controller.OcorrenciaController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllersConfig {

    @Bean
    public OcorrenciaController ocorrenciaController(
            CreateOcorrenciaUseCase createOcorrenciaUseCase,
            UpdateOcorrenciaUseCase updateOcorrenciaUseCase,
            DeleteOcorrenciaUseCase deleteOcorrenciaUseCase,
            GetOcorrenciasUseCase getOcorrenciasUseCase,
            GetOcorrenciaUseCase getOcorrenciaUseCase,
            GetOcorrenciasRelatorioUseCase getOcorrenciasRelatorioUseCase,
            GetOcorrenciasAtivoFalseUseCase getOcorrenciasAtivoFalseUseCase,
            PatchOcorrenciaAtivoUseCase patchOcorrenciaAtivoUseCase,
            GetCameraUseCase getCameraUseCase,
            GetEstacaoUseCase getEstacaoUseCase,
            GetCcoUseCase getCcoUseCaseImpl
    ) {
        return new OcorrenciaController(
                createOcorrenciaUseCase, updateOcorrenciaUseCase,
                deleteOcorrenciaUseCase, getOcorrenciasUseCase,
                getOcorrenciaUseCase, getOcorrenciasRelatorioUseCase,
                getOcorrenciasAtivoFalseUseCase, patchOcorrenciaAtivoUseCase,
                getCameraUseCase,
                getEstacaoUseCase, getCcoUseCaseImpl
        );
    }

}
