package br.com.saasSoveteria.sorveteria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loja_id", nullable = false, updatable = false)
    private Long lojaId;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false)
    private boolean ativo = true;

    protected Categoria() { }

    public Categoria(Long lojaId, String nome) {
        this.lojaId = lojaId;
        this.nome = nome;
    }

    public Long getId() { return id; }
    public Long getLojaId() { return lojaId; }
    public String getNome() { return nome; }
    public boolean isAtivo() { return ativo; }

    public void setNome(String nome) { this.nome = nome; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}