CREATE TABLE IF NOT EXISTS carros (
                                          id BIGSERIAL PRIMARY KEY,
                                          placa VARCHAR(100) NOT NULL UNIQUE,
    trem_id BIGINT NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_carros_trem
    FOREIGN KEY (trem_id)
    REFERENCES trems(id)
    ON DELETE CASCADE
    );