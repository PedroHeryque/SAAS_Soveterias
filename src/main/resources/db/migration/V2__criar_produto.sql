CREATE TABLE produto(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco_unidade NUMERIC(10,2),
    valor_adicional NUMERIC(10,2) NOT NULL  DEFAULT 0,
    modo_cobranca VARCHAR(20) NOT NULL,
    descricao VARCHAR(255),
    unidade_min INTEGER,
    unidade_max INTEGER,
    complementos_por_unidade INTEGER NOT NULL DEFAULT 0,
    ativo BOOLEAN NOT NULL  DEFAULT  TRUE,
    disponivel BOOLEAN NOT NULL  DEFAULT TRUE,
    criado_em TIMESTAMP NOT NULL  DEFAULT CURRENT_TIMESTAMP,

    loja_id BIGINT NOT NULL REFERENCES loja(id),
    CHECK ( modo_cobranca IN ('POR_VARIACAO', 'POR_UNIDADE') ),
    CHECK ( valor_adicional>=0 )

);
CREATE INDEX idx_produto_loja ON produto (loja_id);