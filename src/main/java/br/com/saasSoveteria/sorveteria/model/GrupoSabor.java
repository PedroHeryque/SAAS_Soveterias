package br.com.saasSoveteria.sorveteria.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "grupo_sabor")
public class GrupoSabor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loja_id", nullable = false, updatable = false)
    private Long lojaId;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal acrescimo = BigDecimal.ZERO;

    @Column(nullable = false)
    private boolean ativo = true;

    protected GrupoSabor() { }

    public GrupoSabor(Long lojaId, String nome, BigDecimal acrescimo) {
        this.lojaId = lojaId;
        this.nome = nome;
        this.acrescimo = acrescimo;
    }

    public Long getId() { return id; }
    public Long getLojaId() { return lojaId; }
    public String getNome() { return nome; }
    public BigDecimal getAcrescimo() { return acrescimo; }
    public boolean isAtivo() { return ativo; }

    public void setNome(String nome) { this.nome = nome; }
    public void setAcrescimo(BigDecimal acrescimo) { this.acrescimo = acrescimo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}