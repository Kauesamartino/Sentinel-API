CREATE TABLE IF NOT EXISTS relatorios (
                                          id BIGSERIAL PRIMARY KEY,
                                          titulo VARCHAR(50) NOT NULL UNIQUE,
    descricao TEXT NOT NULL,
    data_inicio TIMESTAMP NOT NULL,
    data_fim TIMESTAMP NOT NULL,
    tipo_ocorrencia VARCHAR(25)
    );
