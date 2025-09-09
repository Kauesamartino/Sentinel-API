package com.sentinel.api.domain.model;

import com.sentinel.api.domain.enums.Linha;
import com.sentinel.api.interfaces.dto.estacao.EstacaoInDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Estacao {

    private Long id;
    private String nome;
    private Linha linha;
    private Long idCco;
    private Endereco endereco;

    public Estacao(EstacaoInDto dados) {
        if (dados.nome() == null || dados.nome().isEmpty()) {
            throw new IllegalArgumentException("Nome da estação é obrigatório");
        }
        if (dados.linha() == null){
            throw new IllegalArgumentException("Linha da estação é obrigatório");
        }
        if (dados.endereco() == null){
            throw new IllegalArgumentException("Endereço da estação é obrigatório");
        }
        this.nome = dados.nome();
        this.linha = dados.linha();
        this.idCco = dados.idCco();
        this.endereco = new Endereco(
                dados.endereco().logradouro(),
                dados.endereco().bairro(),
                dados.endereco().cep(),
                dados.endereco().numero(),
                dados.endereco().complemento(),
                dados.endereco().cidade(),
                dados.endereco().uf()
        );
    }
}