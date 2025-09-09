package com.sentinel.api.infrastructure.entity;

import com.sentinel.api.domain.enums.Linha;
import com.sentinel.api.domain.model.Endereco;
import com.sentinel.api.domain.model.Estacao;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "estacoes")
@Entity(name = "Estacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class JpaEstacaoEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Linha linha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cco_id")
    private JpaCentroControleOperacoesEntity jpaCentroControleOperacoesEntity;

    @Embedded
    private Endereco endereco;

    public JpaEstacaoEntity(Estacao estacao, JpaCentroControleOperacoesEntity cco) {
        this.nome = estacao.getNome();
        this.linha = estacao.getLinha();
        this.jpaCentroControleOperacoesEntity = cco;
        this.endereco = new Endereco(
                estacao.getEndereco().getLogradouro(),
                estacao.getEndereco().getBairro(),
                estacao.getEndereco().getCep(),
                estacao.getEndereco().getNumero(),
                estacao.getEndereco().getComplemento(),
                estacao.getEndereco().getCidade(),
                estacao.getEndereco().getUf()
        );
    }
}
