CREATE SCHEMA IF NOT EXISTS lgbtq DEFAULT CHARACTER SET utf8 ;

USE lgbtq ;

CREATE TABLE IF NOT EXISTS servico (
  id INT AUTO_INCREMENT,
  designacao VARCHAR(45) NULL,
  PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS endereco (
  id INT AUTO_INCREMENT,
  logradouro VARCHAR(45) NULL,
  numero VARCHAR(45) NULL,
  bairro VARCHAR(45) NULL,
  cidade VARCHAR(45) NULL,
  estado VARCHAR(45) NULL,
  cep VARCHAR(45) NULL,
  PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS coordenada (
  id INT AUTO_INCREMENT,
  longitude VARCHAR(45) NULL,
  latitude VARCHAR(45) NULL,
  PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS local (
  id INT AUTO_INCREMENT,
  nome VARCHAR(45) NULL,
  link VARCHAR(45) NULL,
  descricao VARCHAR(45) NULL,
  coordenada_id INT,
  endereco_id INT NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (endereco_id)
    REFERENCES endereco (id),
    FOREIGN KEY (coordenada_id)
    REFERENCES coordenada (id));

CREATE TABLE IF NOT EXISTS instituicao (
  cnpj VARCHAR(45) NOT NULL,
  razao_social VARCHAR(45) NULL,
  horario_abertura VARCHAR(45) NULL,
  horario_fechamento VARCHAR(45) NULL,
  coordenada_id INT,
  endereco_id INT NOT NULL,
  PRIMARY KEY (cnpj),
    FOREIGN KEY (endereco_id)
    REFERENCES endereco (id),
    FOREIGN KEY (coordenada_id)
    REFERENCES coordenada (id));

 CREATE TABLE IF NOT EXISTS acolhido (
  cpf VARCHAR(45) NOT NULL,
  rg VARCHAR(45) NULL,
  nome VARCHAR(100) NULL,
  tipo_contato VARCHAR(45) NULL,
  contato VARCHAR(45) NULL,
  data_nascimento VARCHAR(45) NULL,
  coordenada_id INT,
  PRIMARY KEY (cpf),
    FOREIGN KEY (coordenada_id)
    REFERENCES coordenada (id));

CREATE TABLE IF NOT EXISTS comentario_instituicao (
  id INT AUTO_INCREMENT,
  texto VARCHAR(45) NULL,
  instituicao_cnpj VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (instituicao_cnpj)
    REFERENCES instituicao (cnpj));

CREATE TABLE IF NOT EXISTS comentario_local (
  id INT AUTO_INCREMENT,
  texto VARCHAR(45) NULL,
  avaliacao INT NULL,
  local_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (local_id)
  REFERENCES local (id));

CREATE TABLE IF NOT EXISTS descricao_servico (
  id INT AUTO_INCREMENT,
  descricao VARCHAR(45) NULL,
  instituicao_cnpj VARCHAR(45) NOT NULL,
  servico_id INT NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (instituicao_cnpj)
    REFERENCES instituicao (cnpj),
    FOREIGN KEY (servico_id)
    REFERENCES servico (id));

CREATE TABLE IF NOT EXISTS alerta (
  id INT AUTO_INCREMENT,
  status VARCHAR(45) NULL,
  acolhido_cpf VARCHAR(45) NOT NULL,
  instituicao_cnpj VARCHAR(45),
  PRIMARY KEY (id),
    FOREIGN KEY (instituicao_cnpj)
    REFERENCES instituicao (cnpj),
    FOREIGN KEY (acolhido_cpf)
    REFERENCES acolhido (cpf));
