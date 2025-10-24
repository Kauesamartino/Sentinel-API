package com.sentinel.api.interfaces.controller;

import com.sentinel.api.interfaces.dto.estacao.EstacaoInDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoLazyOutDto;
import com.sentinel.api.interfaces.dto.estacao.EstacaoOutDto;
import org.springframework.data.domain.Page;

public interface EstacaoController {

    /**
     * Cadastra uma nova estação.
     *
     * @param estacaoInDto Dados de entrada da estação a ser cadastrada.
     * @return Dados de saída da estação cadastrada.
     */
    EstacaoOutDto cadastrar(EstacaoInDto estacaoInDto);

    /**
     * Lista todas as estações com paginação.
     *
     * @param pageSize Tamanho da página.
     * @param pageNumber Número da página.
     * @return Página de estações.
     */
    Page<EstacaoLazyOutDto> listar(Integer pageSize, Integer pageNumber);

    /**
     * Detalha uma estação específica pelo seu ID.
     *
     * @param id ID da estação a ser detalhada.
     * @return Detalhes da estação.
     */
    EstacaoOutDto detalhar(Long id);

    /**
     * Deleta uma estação pelo seu ID.
     *
     * @param id ID da estação a ser deletada.
     */
    void deletar(Long id);
}
