package com.sentinel.api.interfaces.controller;

import com.sentinel.api.interfaces.dto.ocorrencia.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

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

    /**
     * Lista o número de ocorrências registradas na última hora.
     *
     * @return lista de ocorrências na última hora
     */
    List<OcorrenciaDashboardsOutDto> listarOcorrenciasDashboardHora();

    /**
     * Lista todas as ocorrências registradas no sistema.
     *
     * @return lista de todas as ocorrências
     */
    List<OcorrenciaDashboardsOutDto> listarTodasOcorrencias();

    /**
     * Lista as ocorrências registradas entre duas datas específicas.
     *
     * @param startDate data de início
     * @param endDate data de fim
     * @return lista de ocorrências entre as datas
     */
    List<OcorrenciaDashboardsOutDto> listarOcorrenciasPorData(LocalDateTime startDate, LocalDateTime endDate);
}
