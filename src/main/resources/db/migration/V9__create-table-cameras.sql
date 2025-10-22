CREATE TABLE IF NOT EXISTS cameras(
                                            id BIGSERIAL PRIMARY KEY,
    codigo VARCHAR(50) NOT NULL UNIQUE,
    modelo VARCHAR(100) NOT NULL,
    carro_id BIGINT NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_cameras_carro
    FOREIGN KEY (carro_id)
    REFERENCES carros(id)
    ON DELETE CASCADE
);