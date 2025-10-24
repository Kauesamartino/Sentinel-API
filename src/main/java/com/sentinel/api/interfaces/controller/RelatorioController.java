package com.sentinel.api.interfaces.controller;

import com.sentinel.api.interfaces.dto.relatorio.RelatorioInDto;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioLazyOutDto;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioOutDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public interface RelatorioController {

    /**
     * Cadastrar um novo Relatório.
     *
     * @param relatorioInDto Dados de entrada para o Relatório.
     * @return Dados de saída do Relatório cadastrado.
     */
    RelatorioOutDto cadastrar(RelatorioInDto relatorioInDto);

    /**
     * Lista todos os relatórios com paginação e ordenação.
     *
     * @param pageSize tamanho da página
     * @param pageNumber número da página
     * @param direction direção da ordenação (ASC ou DESC)
     * @return página de relatórios
     */
    Page<RelatorioLazyOutDto> listar(Integer pageSize, Integer pageNumber, Sort.Direction direction);

}
