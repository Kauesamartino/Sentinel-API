package com.sentinel.api.infrastructure.entity;

import com.sentinel.api.domain.enums.TipoOcorrencia;
import com.sentinel.api.domain.model.Relatorio;
import com.sentinel.api.interfaces.dto.relatorio.RelatorioInDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "relatorios")
@Entity(name = "Relatorio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class JpaRelatorioEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    private TipoOcorrencia tipoOcorrencia;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public JpaRelatorioEntity(Relatorio dados) {
        this.titulo = dados.getTitulo();
        this.descricao = dados.getDescricao();
        this.tipoOcorrencia = dados.getTipoOcorrencia();
        this.dataInicio = dados.getDataInicio();
        this.dataFim = dados.getDataFim();
    }


}
