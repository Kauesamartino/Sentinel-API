package com.sentinel.api.interfaces.controller;

import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaInDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaLazyOutDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaOutDetailDto;
import com.sentinel.api.interfaces.dto.ocorrencia.OcorrenciaUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface OcorrenciaController {

    /**
     * Cria uma nova ocorrência no sistema.
     *
     * @param ocorrenciaInDto dados da ocorrência a ser criada
     * @return dados da ocorrência criada
     */
    OcorrenciaOutDetailDto cadastrar(OcorrenciaInDto ocorrenciaInDto);

    /**
     * Lista todas as ocorrências de um relatorio ativas com paginação e ordenação.
     *
     * @param id do relatorio
     * @param pageSize tamanho da página
     * @param pageNumber número da página
     * @param direction direção da ordenação (ASC ou DESC)
     * @return página de ocorrências associadas ao relatorio
     */
    Page<OcorrenciaLazyOutDto> listarOcorrenciasDeUmRelatorio(Long id, Integer pageSize, Integer pageNumber, Sort.Direction direction);


    /**
     * Detalha uma ocorrência específica pelo seu ID.
     *
     * @param id da ocorrência a ser detalhada
     * @return detalhes da ocorrência
     */
    OcorrenciaOutDetailDto detalhar(Long id);

    /**
     * Lista todas as ocorrências ativas com paginação e ordenação.
     *
     * @param pageSize tamanho da página
     * @param pageNumber número da página
     * @param direction direção da ordenação (ASC ou DESC)
     * @return página de ocorrências ativas
     */
    Page<OcorrenciaLazyOutDto> listar(Integer pageSize, Integer pageNumber, Sort.Direction direction);

    /**
     * Lista todas as ocorrências em curadoria (inativas) com paginação e ordenação.
     *
     * @param pageSize tamanho da página
     * @param pageNumber número da página
     * @param direction direção da ordenação (ASC ou DESC)
     * @return página de ocorrências em curadoria
     */
    Page<OcorrenciaLazyOutDto> listarOcorrenciasCuradoria(Integer pageSize, Integer pageNumber, Sort.Direction direction);

    /**
     * Atualiza uma ocorrência existente pelo seu ID.
     *
     * @param id da ocorrência a ser atualizada
     * @param ocorrenciaUpdateDto dados atualizados da ocorrência
     * @return detalhes da ocorrência atualizada
     */
    OcorrenciaOutDetailDto atualizar(Long id, OcorrenciaUpdateDto ocorrenciaUpdateDto);

    /**
     * Ativa uma ocorrência que estava em curadoria.
     *
     * @param id da ocorrência a ser ativada
     */
    void excluir(Long id);

    /**
     * Ativa uma ocorrência que estava em curadoria.
     *
     * @param id da ocorrência a ser ativada
     */
    void ativar(Long id);
}
