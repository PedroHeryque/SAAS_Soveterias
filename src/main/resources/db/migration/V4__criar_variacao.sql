CREATE TABLE variacao (
    id                     BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    loja_id                BIGINT        NOT NULL REFERENCES loja(id),
    produto_id             BIGINT        NOT NULL REFERENCES produto(id),
    nome                   VARCHAR(60)   NOT NULL,
    preco                  NUMERIC(10,2) NOT NULL,
    complementos_incluidos INTEGER       NOT NULL DEFAULT 0,
    max_sabores            INTEGER       NOT NULL DEFAULT 0,
    disponivel             BOOLEAN       NOT NULL DEFAULT TRUE,
    ativo                  BOOLEAN       NOT NULL DEFAULT TRUE,
    UNIQUE (produto_id, nome),
    CHECK (preco >= 0),
    CHECK (complementos_incluidos >= 0),
    CHECK (max_sabores >= 0)
);

CREATE INDEX idx_variacao_loja ON variacao (loja_id);