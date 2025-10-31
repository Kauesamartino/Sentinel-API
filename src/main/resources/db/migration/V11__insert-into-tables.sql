insert into trems (numero_trem, ativo) values
('TREM-001', TRUE),
('TREM-002', TRUE),
('TREM-003', TRUE);

insert into carros (placa, trem_id, ativo) values
('A001', 1, TRUE),
('A002', 1, TRUE),
('A003', 2, TRUE),
('A004', 2, TRUE),
('A005', 3, TRUE);

insert into cameras (codigo, modelo, carro_id, ativo) values
('CAM-001', 'Modelo X', 1, TRUE),
('CAM-002', 'Modelo Y', 1, TRUE),
('CAM-003', 'Modelo X', 2, TRUE),
('CAM-004', 'Modelo Z', 3, TRUE),
('CAM-005', 'Modelo Y', 4, TRUE);