package br.com.saasSoveteria.sorveteria.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loja_id", nullable = false, updatable = false)
    private Long lojaId;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 255)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "modo_cobranca", nullable = false, length = 20)
    private ModoCobranca modoCobranca;

    @Column(name = "preco_unidade", precision = 10, scale = 2)
    private BigDecimal precoUnidade;

    @Column(name = "unidade_min")
    private Integer unidadeMin;

    @Column(name = "unidade_max")
    private Integer unidadeMax;

    @Column(name = "complementos_por_unidade", nullable = false)
    private int complementosPorUnidade = 0;

    @Column(name = "valor_adicional", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorAdicional = BigDecimal.ZERO;

    @Column(nullable = false)
    private boolean disponivel = true;

    @Column(nullable = false)
    private boolean ativo = true;

    @Column(name = "criado_em", insertable = false, updatable = false)
    private LocalDateTime criadoEm;

    @ManyToMany
    @JoinTable(name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "produto_complemento",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "complemento_id"))
    private Set<Complemento> complementos = new HashSet<>();

    protected Produto() { }

    public Produto(Long lojaId, String nome, ModoCobranca modoCobranca) {
        this.lojaId = lojaId;
        this.nome = nome;
        this.modoCobranca = modoCobranca;
    }

    public Long getId() { return id; }
    public Long getLojaId() { return lojaId; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public ModoCobranca getModoCobranca() { return modoCobranca; }
    public BigDecimal getPrecoUnidade() { return precoUnidade; }
    public Integer getUnidadeMin() { return unidadeMin; }
    public Integer getUnidadeMax() { return unidadeMax; }
    public int getComplementosPorUnidade() { return complementosPorUnidade; }
    public BigDecimal getValorAdicional() { return valorAdicional; }
    public boolean isDisponivel() { return disponivel; }
    public boolean isAtivo() { return ativo; }
    public LocalDateTime getCriadoEm() { return criadoEm; }
    public Set<Categoria> getCategorias() { return categorias; }
    public Set<Complemento> getComplementos() { return complementos; }

    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setModoCobranca(ModoCobranca modoCobranca) { this.modoCobranca = modoCobranca; }
    public void setPrecoUnidade(BigDecimal precoUnidade) { this.precoUnidade = precoUnidade; }
    public void setUnidadeMin(Integer unidadeMin) { this.unidadeMin = unidadeMin; }
    public void setUnidadeMax(Integer unidadeMax) { this.unidadeMax = unidadeMax; }
    public void setComplementosPorUnidade(int valor) { this.complementosPorUnidade = valor; }
    public void setValorAdicional(BigDecimal valorAdicional) { this.valorAdicional = valorAdicional; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}