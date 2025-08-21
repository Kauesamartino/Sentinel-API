package com.sentinel.api.domain.evidencia;

import com.sentinel.api.domain.estacao.Estacao;
import com.sentinel.api.domain.ocorrencia.DadosCadastroOcorrencia;
import com.sentinel.api.domain.ocorrencia.Ocorrencia;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "evidencias")
@Entity(name = "Evidencia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Evidencia {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String key;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ocorrencia")
    private Ocorrencia ocorrencia;
    
    public Evidencia(DadosCadastroEvidencia dados, Ocorrencia ocorrencia) {
        this.key = dados.key();
        this.ocorrencia = ocorrencia;
    }
}
