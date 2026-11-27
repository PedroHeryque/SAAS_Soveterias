package br.com.saasSoveteria.sorveteria.dto;

import br.com.saasSoveteria.sorveteria.model.Complemento;

public record ComplementosResponse(Long id , String nome, boolean disponivel, boolean ativo) {
    public static ComplementosResponse de (Complemento complemento) {
        return new ComplementosResponse(
                complemento.getId(),
                complemento.getNome(),
                complemento.isAtivo(),
                complemento.isDisponivel()
        );
    }

}
