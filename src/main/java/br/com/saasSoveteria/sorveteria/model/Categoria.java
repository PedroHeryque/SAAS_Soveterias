package br.com.saasSoveteria.sorveteria.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column( name ="loja_id", nullable = false)
    private Long lojaId;

    @Column( nullable = false , length = 60)
    private  String nome;

    @Column(nullable = false)
    private boolean ativo = true;

    public Categoria(){
    }

    public Categoria( Long lojaId, String nome){
        this.lojaId = lojaId;
        this.nome= nome;
    }


    public void setNome(String nome){
        this.nome = nome;
    }
    public  String getNome(){
        return nome;
    }
    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }
    public boolean getAtivo(){
        return  ativo;
    }


}
