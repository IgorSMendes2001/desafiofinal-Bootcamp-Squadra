insert into tb_bairro( nome,status ,codigo_municipio)values ('Laranjeiras',1,2);
insert into tb_bairro( nome,status ,codigo_municipio)values ('Centro',1,3);
insert into tb_bairro( nome,status ,codigo_municipio)values ('Morro Grande',1,4);
insert into tb_bairro( nome,status ,codigo_municipio)values ('Alvorada',1,2);

INSERT INTO tb_pessoa(nome, sobrenome, idade, login, senha, status) VALUES('João ', 'Da Silva', 53, 'joao', 'dsa53', 1)
INSERT INTO tb_pessoa(nome, sobrenome, idade, login, senha, status) VALUES('José ', 'Pereira', 68, 'jose', 'per68', 2)
INSERT INTO tb_pessoa(nome, sobrenome, idade, login, senha, status) VALUES('Maria ', 'Ferreira', 45,'maria', 'mar45', 1)
INSERT INTO tb_pessoa(nome, sobrenome, idade, login, senha, status) VALUES('Vicente ', 'Souza', 18, 'vicente', 'vic18', 2)


INSERT INTO tb_municipio(codigo_uf, nome, status) VALUES(1, 'Carmo do Paranaiba', 1)
INSERT INTO tb_municipio(codigo_uf, nome, status) VALUES(1, 'Patos de Minas', 1)
INSERT INTO tb_municipio(codigo_uf, nome, status) VALUES(1, 'Goiânia', 2)

INSERT INTO estacionamento(data, placa, valor, pessoa_id, veiculo_tipo_id) VALUES ('2022-05-22','IJK-0L30', 5, 1, 1)
INSERT INTO estacionamento(data, placa, valor, pessoa_id, veiculo_tipo_id) VALUES ('2022-05-11','ABC-1D40', 10, 2, 2)
INSERT INTO estacionamento(data, placa, valor, pessoa_id, veiculo_tipo_id) VALUES ('2022-05-11','DFG-1H22', 15, 3, 3)



INSERT INTO tb_uf(sigla,nome,status) VALUES ('MG','Minas Gerais',1)
INSERT INTO tb_uf(sigla,nome,status) VALUES ('GO','Goiás',2)
INSERT INTO tb_uf(sigla,nome,status) VALUES ('SP','São Paulo',2)
INSERT INTO tb_uf(sigla,nome,status) VALUES ('RJ','Rio de Janeiro',1)
INSERT INTO tb_uf(sigla,nome,status) VALUES ('RS','Rio Grande do Sul',1)

INSERT INTO tb_endereco(codigo_pessoa, codigo_bairro, nome_rua,numero,complemento,cep) VALUES(1, 1, 'Castanhais', 123,'Residencial Vitoria',22555111333)
INSERT INTO tb_endereco(codigo_pessoa, codigo_bairro, nome_rua,numero,complemento,cep) VALUES(2, 2, 'Paraisópolis', 1445,'Apto 201',848484484844)

