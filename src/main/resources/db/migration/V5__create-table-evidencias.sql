-- V5__create_table_evidencias.sql
CREATE TABLE evidencias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    `key` VARCHAR(255) NOT NULL,
    id_ocorrencia BIGINT,
    CONSTRAINT fk_evidencias_ocorrencias FOREIGN KEY (id_ocorrencia)
        REFERENCES ocorrencias(id)
);
