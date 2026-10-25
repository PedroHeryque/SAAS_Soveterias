CREATE TABLE produto_categoria(
    produto_id BIGINT NOT NULL REFERENCES produto(id),
    categoria_id BIGINT NOT NULL REFERENCES categoria(id),
    PRIMARY KEY (produto_id, categoria_id)
);
CREATE INDEX idx_produto_categoria_categoria ON produto_categoria(categoria_id);
