ALTER TABLE pacientes ADD status TINYINT;

UPDATE pacientes SET status = 1;
