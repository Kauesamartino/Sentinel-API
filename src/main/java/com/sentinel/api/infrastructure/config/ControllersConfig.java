package com.sentinel.api.infrastructure.config;

import com.sentinel.api.application.usecase.camera.GetCameraUseCase;
import com.sentinel.api.application.usecase.cco.CreateCcoUseCase;
import com.sentinel.api.application.usecase.cco.GetCcoUseCase;
import com.sentinel.api.application.usecase.estacao.CreateEstacaoUseCase;
import com.sentinel.api.application.usecase.estacao.DeleteEstacaoUseCase;
import com.sentinel.api.application.usecase.estacao.GetEstacaoUseCase;
import com.sentinel.api.application.usecase.estacao.GetEstacoesUseCase;
import com.sentinel.api.application.usecase.ocorrencia.*;
import com.sentinel.api.application.usecase.relatorio.CreateRelatorioUseCase;
import com.sentinel.api.application.usecase.relatorio.GetRelatoriosUseCase;
import com.sentinel.api.interfaces.controller.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllersConfig {

    @Bean
    public OcorrenciaController ocorrenciaController(
            CreateOcorrenciaUseCase createOcorrenciaUseCase, UpdateOcorrenciaUseCase updateOcorrenciaUseCase,
            DeleteOcorrenciaUseCase deleteOcorrenciaUseCase, GetOcorrenciasUseCase getOcorrenciasUseCase,
            GetOcorrenciaUseCase getOcorrenciaUseCase, GetOcorrenciasRelatorioUseCase getOcorrenciasRelatorioUseCase,
            GetOcorrenciasAtivoFalseUseCase getOcorrenciasAtivoFalseUseCase, PatchOcorrenciaAtivoUseCase patchOcorrenciaAtivoUseCase,
            GetCameraUseCase getCameraUseCase, GetEstacaoUseCase getEstacaoUseCase, GetCcoUseCase getCcoUseCase,
            GetOcorrenciasDashboardHoraUseCase getOcorrenciasDashboardHoraUseCase, GetAllOcorrenciasDashboardUseCase getAllOcorrenciasDashboardUseCase,
            GetAllOcorrenciasBetweenDatesUseCase getAllOcorrenciasBetweenDatesUseCase
    ) {
        return new OcorrenciaControllerImpl(
                createOcorrenciaUseCase, updateOcorrenciaUseCase, deleteOcorrenciaUseCase,
                getOcorrenciasUseCase, getOcorrenciaUseCase, getOcorrenciasRelatorioUseCase,
                getOcorrenciasAtivoFalseUseCase, patchOcorrenciaAtivoUseCase,
                getCameraUseCase, getEstacaoUseCase, getCcoUseCase,
                getOcorrenciasDashboardHoraUseCase, getAllOcorrenciasDashboardUseCase,
                getAllOcorrenciasBetweenDatesUseCase
        );
    }

    @Bean
    public CentroControleOperacoesController centroControleOperacoesController(
            CreateCcoUseCase createCcoUseCase
    ){
        return new CentroControleOperacoesControllerImpl(createCcoUseCase);
    }

    @Bean
    public EstacaoController estacaoController(
            CreateEstacaoUseCase createEstacaoUseCase, GetEstacoesUseCase getEstacoesUseCase,
            GetEstacaoUseCase getEstacaoUseCase, DeleteEstacaoUseCase deleteEstacaoUseCase,
            GetCcoUseCase getCcoUseCase
    ){
        return new EstacaoControllerImpl(
                createEstacaoUseCase, getEstacoesUseCase, getEstacaoUseCase, deleteEstacaoUseCase, getCcoUseCase
        );
    }

    @Bean
    public RelatorioController relatorioController(
            CreateRelatorioUseCase createRelatorioUseCase, GetRelatoriosUseCase getRelatoriosUseCase
    ){
        return new RelatorioControllerImpl(createRelatorioUseCase, getRelatoriosUseCase);
    }

}
