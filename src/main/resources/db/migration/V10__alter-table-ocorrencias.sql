ALTER TABLE ocorrencias
    ADD COLUMN camera_id BIGINT,
    ADD CONSTRAINT fk_ocorrencias_cameras
    FOREIGN KEY (camera_id)
    REFERENCES cameras(id)
    ON DELETE SET NULL;