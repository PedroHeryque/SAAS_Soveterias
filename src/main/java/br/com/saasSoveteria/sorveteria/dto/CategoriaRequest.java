package br.com.saasSoveteria.sorveteria.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoriaRequest(
        @NotBlank(message =  "nome da categoria obrigatório.")
        @Size(max = 60 , message = "O nome pode ter no maximo 60 caracteres")
        String nome) {

}
