package br.com.saasSoveteria.sorveteria.dto;
import br.com.saasSoveteria.sorveteria.model.Categoria;

public record CategoriaResponse(Long id , String nome, boolean ativo) {
    public  static  CategoriaResponse de(Categoria categoria){
        return  new CategoriaResponse(
                categoria.getId(),
                categoria.getNome(),
                categoria.isAtivo()
        );
    }

}
