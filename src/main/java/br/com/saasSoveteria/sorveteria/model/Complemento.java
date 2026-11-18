
package br.com.saasSoveteria.sorveteria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "complemento")
public class Complemento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loja_id", nullable = false, updatable = false)
    private Long lojaId;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false)
    private boolean disponivel = true;

    @Column(nullable = false)
    private boolean ativo = true;

    protected Complemento() { }

    public Complemento(Long lojaId, String nome) {
        this.lojaId = lojaId;
        this.nome = nome;
    }

    public Long getId() { return id; }
    public Long getLojaId() { return lojaId; }
    public String getNome() { return nome; }
    public boolean isDisponivel() { return disponivel; }
    public boolean isAtivo() { return ativo; }

    public void setNome(String nome) { this.nome = nome; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}