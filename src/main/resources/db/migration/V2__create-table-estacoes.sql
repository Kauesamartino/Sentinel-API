CREATE TABLE IF NOT EXISTS estacoes (
                                        id BIGSERIAL PRIMARY KEY,
                                        nome VARCHAR(255) NOT NULL,
    linha VARCHAR(255) NOT NULL,
    cco_id BIGINT NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    numero VARCHAR(50),
    complemento VARCHAR(255),
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    cep VARCHAR(20) NOT NULL,
    CONSTRAINT fk_estacoes_cco
    FOREIGN KEY (cco_id)
    REFERENCES ccos(id)
    ON DELETE CASCADE
    );
