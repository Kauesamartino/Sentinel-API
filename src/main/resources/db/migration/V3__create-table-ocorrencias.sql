CREATE TABLE IF NOT EXISTS ocorrencias (
                                           id BIGSERIAL PRIMARY KEY,
                                           titulo VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    data TIMESTAMP NOT NULL,
    severidade VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    tipo_ocorrencia VARCHAR(50) NOT NULL,
    estacao_id BIGINT,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_ocorrencias_estacao
    FOREIGN KEY (estacao_id)
    REFERENCES estacoes(id)
    ON DELETE SET NULL
    );
