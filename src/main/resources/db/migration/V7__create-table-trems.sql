CREATE TABLE IF NOT EXISTS trems (
                                          id BIGSERIAL PRIMARY KEY,
    numero_trem VARCHAR(20) NOT NULL UNIQUE,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
    );