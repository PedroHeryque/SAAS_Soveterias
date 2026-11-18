package br.com.saasSoveteria.sorveteria.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name ="loja")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false , length =  60)
    private String slug;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(nullable = false)
    private boolean ativa = true;

    @Column(name = "criada_em", insertable = false, updatable = false)
    private LocalDateTime criadaEm;

    protected Loja() { }

    public Loja(String nome, String slug, String telefone) {
        this.nome = nome;
        this.slug = slug;
        this.telefone = telefone;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getSlug() { return slug; }
    public String getTelefone() { return telefone; }
    public boolean isAtiva() { return ativa; }
    public LocalDateTime getCriadaEm() { return criadaEm; }

    public void setNome(String nome) { this.nome = nome; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setAtiva(boolean ativa) { this.ativa = ativa; }

}
