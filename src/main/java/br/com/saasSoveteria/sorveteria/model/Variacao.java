package br.com.saasSoveteria.sorveteria.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = " variacao")
public class Variacao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "loja_id", nullable = false, updatable = false)
    private Long lojaId;


    @Column(name = "produto_id", nullable = false, updatable  = false)
    private Long produtoId;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, precision = 10 , scale = 2)
    private BigDecimal preco;

    @Column(name = "complementos_incluidos", nullable = false)
    private int complementosIncluidos = 0;

    @Column(name = "max_sabores", nullable = false)
    private int maxSabores =0;

    @Column(nullable = false)
    private boolean disponivel = true;

    @Column(nullable = false)
    private boolean ativo = true;

    public Variacao(){
    }

    public Variacao(Long lojaId , Long  produtoId , String nome, BigDecimal preco){
        this.lojaId =lojaId;
        this.produtoId = produtoId;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLojaId() {
        return lojaId;
    }

    public void setLojaId(Long lojaId) {
        this.lojaId = lojaId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getComplementosIncluidos() {
        return complementosIncluidos;
    }

    public void setComplementosIncluidos(int complementosIncluidos) {
        this.complementosIncluidos = complementosIncluidos;
    }

    public int getMaxSabores() {
        return maxSabores;
    }

    public void setMaxSabores(int maxSabores) {
        this.maxSabores = maxSabores;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
