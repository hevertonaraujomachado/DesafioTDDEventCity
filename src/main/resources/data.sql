INSERT INTO tb_role(id,authority) VALUES (1,'ROLE_ADMIN');
INSERT INTO tb_role(id,authority) VALUES (2,'ROLE_CLIENT');

INSERT INTO tb_user(id,name,email,password)
VALUES (1,'Bob Brown','bob@gmail.com','$2a$10$Dow1l6v8P2d6z5P9NQh9QeV7M6yKX6uL3U7Ck9K0xXkzG3Z0z9G7a');

INSERT INTO tb_user(id,name,email,password)
VALUES (2,'Ana Silva','ana@gmail.com','$2a$10$Dow1l6v8P2d6z5P9NQh9QeV7M6yKX6uL3U7Ck9K0xXkzG3Z0z9G7a');

INSERT INTO tb_user_role(user_id,role_id) VALUES (1,1);
INSERT INTO tb_user_role(user_id,role_id) VALUES (2,2);

INSERT INTO tb_city(name) VALUES ('São Paulo');
INSERT INTO tb_city(name) VALUES ('Brasília');
INSERT INTO tb_city(name) VALUES ('Fortaleza');
INSERT INTO tb_city(name) VALUES ('Salvador');
INSERT INTO tb_city(name) VALUES ('Manaus');
INSERT INTO tb_city(name) VALUES ('Curitiba');
INSERT INTO tb_city(name) VALUES ('Goiânia');
INSERT INTO tb_city(name) VALUES ('Belém');
INSERT INTO tb_city(name) VALUES ('Porto Alegre');
INSERT INTO tb_city(name) VALUES ('Rio de Janeiro');
INSERT INTO tb_city(name) VALUES ('Belo Horizonte');

INSERT INTO tb_event(name,date,url,city_id) VALUES ('Feira do Software','2099-05-16','https://feiradosoftware.com',1);
INSERT INTO tb_event(name,date,url,city_id) VALUES ('CCXP','2099-04-13','https://ccxp.com.br',1);
INSERT INTO tb_event(name,date,url,city_id) VALUES ('Congresso Linux','2099-05-23','https://congressolinux.com.br',2);
INSERT INTO tb_event(name,date,url,city_id) VALUES ('Semana Spring React','2099-05-03','https://devsuperior.com.br',3);
