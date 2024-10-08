-- Criação da tabela de Usuários
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,              -- Chave primária
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE, -- E-mail único
    senha VARCHAR(255) NOT NULL
);

-- Criação da tabela de Equipamentos
CREATE TABLE equipamentos (
    id SERIAL PRIMARY KEY,              -- Chave primária
    nome VARCHAR(100) NOT NULL,
    marca VARCHAR(100),
    modelo VARCHAR(100),
    ano_fabricacao INT
);

-- Criação da tabela de Manutenções
CREATE TABLE manutencoes (
    id SERIAL PRIMARY KEY,                  -- Chave primária
    id_equipamento INT NOT NULL,             -- Chave estrangeira para equipamentos
    tipo_manutencao VARCHAR(50),             -- Preventiva ou Corretiva
    descricao TEXT NOT NULL,
    data_agendada DATE,                      -- Data para manutenções preventivas
    data_realizada DATE,                     -- Data para manutenções corretivas
    CONSTRAINT fk_equipamento
        FOREIGN KEY (id_equipamento)         -- Definição de chave estrangeira
        REFERENCES equipamentos(id)
        ON DELETE CASCADE
);

-- Criação de Índices para otimizar consultas
CREATE INDEX idx_equipamento_nome ON equipamentos(nome);
CREATE INDEX idx_usuario_email ON usuarios(email);

-- Adição de dados de exemplo para testes (opcional)
INSERT INTO usuarios (nome, email, senha) VALUES 
('Admin', 'admin@example.com', 'senha123'),
('João Silva', 'joao@example.com', 'senha456');

INSERT INTO equipamentos (nome, marca, modelo, ano_fabricacao) VALUES
('Compressor', 'ABC', 'XZ200', 2018),
('Gerador', 'PowerGen', 'GT500', 2020),
('Esteira Transportadora', 'IndMachines', 'ST300', 2015);

-- Exemplo de manutenções (opcional)
INSERT INTO manutencoes (id_equipamento, tipo_manutencao, descricao, data_agendada, data_realizada) VALUES
(1, 'Preventiva', 'Troca de óleo e revisão', '2024-10-15', NULL),
(2, 'Corretiva', 'Substituição de peças quebradas', NULL, '2024-08-12');
