package br.com.saasSoveteria.sorveteria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sabor")
public class Sabor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loja_id", nullable = false, updatable = false)
    private Long lojaId;

    @Column(name = "grupo_sabor_id", nullable = false)
    private Long grupoSaborId;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false)
    private boolean disponivel = true;

    @Column(nullable = false)
    private boolean ativo = true;

    protected Sabor() { }

    public Sabor(Long lojaId, Long grupoSaborId, String nome) {
        this.lojaId = lojaId;
        this.grupoSaborId = grupoSaborId;
        this.nome = nome;
    }

    public Long getId() { return id; }
    public Long getLojaId() { return lojaId; }
    public Long getGrupoSaborId() { return grupoSaborId; }
    public String getNome() { return nome; }
    public boolean isDisponivel() { return disponivel; }
    public boolean isAtivo() { return ativo; }

    public void setGrupoSaborId(Long grupoSaborId) { this.grupoSaborId = grupoSaborId; }
    public void setNome(String nome) { this.nome = nome; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}