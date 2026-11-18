CREATE TABLE grupo_sabor (
    id        BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    loja_id   BIGINT        NOT NULL REFERENCES loja(id),
    nome      VARCHAR(60)   NOT NULL,
    acrescimo NUMERIC(10,2) NOT NULL DEFAULT 0,
    ativo     BOOLEAN       NOT NULL DEFAULT TRUE,
    UNIQUE (loja_id, nome),
    CHECK (acrescimo >= 0)
);

CREATE TABLE sabor (
    id             BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    loja_id        BIGINT      NOT NULL REFERENCES loja(id),
    grupo_sabor_id BIGINT      NOT NULL REFERENCES grupo_sabor(id),
    nome           VARCHAR(60) NOT NULL,
    disponivel     BOOLEAN     NOT NULL DEFAULT TRUE,
    ativo          BOOLEAN     NOT NULL DEFAULT TRUE,
    UNIQUE (loja_id, nome)
);

CREATE INDEX idx_sabor_grupo ON sabor (grupo_sabor_id);
