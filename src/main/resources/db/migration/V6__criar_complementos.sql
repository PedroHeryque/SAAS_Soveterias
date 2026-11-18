CREATE TABLE complemento (
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    loja_id    BIGINT      NOT NULL REFERENCES loja(id),
    nome       VARCHAR(60) NOT NULL,
    disponivel BOOLEAN     NOT NULL DEFAULT TRUE,
    ativo      BOOLEAN     NOT NULL DEFAULT TRUE,
    UNIQUE (loja_id, nome)
);

CREATE TABLE produto_complemento (
    produto_id     BIGINT NOT NULL REFERENCES produto(id),
    complemento_id BIGINT NOT NULL REFERENCES complemento(id),
    PRIMARY KEY (produto_id, complemento_id)
);

CREATE INDEX idx_produto_complemento_complemento ON produto_complemento (complemento_id);

