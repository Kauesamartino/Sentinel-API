package com.sentinel.api.domain.evidencia;

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
}
