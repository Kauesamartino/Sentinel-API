package com.sentinel.api.interfaces.controller;

import com.sentinel.api.interfaces.dto.cco.CcoInDto;
import com.sentinel.api.interfaces.dto.cco.CcoOutDto;

public interface CentroControleOperacoesController {

    /**
     * Cadastrar um novo Centro de Controle de Operações (CCO).
     *
     * @param ccoInDto Dados de entrada para o CCO.
     * @return Dados de saída do CCO cadastrado.
     */
    CcoOutDto cadastrar(CcoInDto ccoInDto);

}
