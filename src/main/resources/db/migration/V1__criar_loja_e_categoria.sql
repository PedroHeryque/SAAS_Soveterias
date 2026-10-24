CREATE TABLE loja (
                      id        BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                      nome      VARCHAR(100) NOT NULL,
                      slug      VARCHAR(60)  NOT NULL UNIQUE,
                      telefone  VARCHAR(20)  NOT NULL,
                      ativa     BOOLEAN      NOT NULL DEFAULT TRUE,
                      criada_em TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE categoria (
                           id       BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                           loja_id  BIGINT      NOT NULL REFERENCES loja(id),
                           nome     VARCHAR(60) NOT NULL,
                           ativo    BOOLEAN     NOT NULL DEFAULT TRUE,
                           UNIQUE (loja_id, nome)
);