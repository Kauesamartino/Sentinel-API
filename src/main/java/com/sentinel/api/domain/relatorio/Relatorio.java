package com.sentinel.api.domain.relatorio;

import com.sentinel.api.domain.ocorrencia.TipoOcorrencia;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "relatorios")
@Entity(name = "Relatorio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Relatorio {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    private TipoOcorrencia tipoOcorrencia;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public Relatorio(DadosCadastroRelatorio dados) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.tipoOcorrencia = dados.tipoOcorrencia();
        this.dataInicio = dados.dataInicio();
        this.dataFim = dados.dataFim();
    }
}
