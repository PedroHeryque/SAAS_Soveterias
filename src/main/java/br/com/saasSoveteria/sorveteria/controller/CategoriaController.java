package br.com.saasSoveteria.sorveteria.controller;

import br.com.saasSoveteria.sorveteria.dto.CategoriaRequest;
import br.com.saasSoveteria.sorveteria.dto.CategoriaResponse;
import br.com.saasSoveteria.sorveteria.model.Categoria;
import br.com.saasSoveteria.sorveteria.repository.CategoriaRepository;
import br.com.saasSoveteria.sorveteria.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")

public class CategoriaController {
    private final CategoriaService  categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }
    @GetMapping
    public List<CategoriaResponse> listar(@RequestHeader("X-Loja-Id") Long lojaId) {
        return categoriaService.listar(lojaId).stream()
                .map(CategoriaResponse::de)
                .toList();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaResponse criar(@RequestHeader("X-Loja-Id") Long lojaId,
                                   @RequestBody CategoriaRequest request) {
        return CategoriaResponse.de(categoriaService.criar(lojaId, request.nome()));
    }
    @GetMapping("/{id}")
    public CategoriaResponse buscar(@RequestHeader("X-Loja-Id") long lojaId,
                                    @PathVariable long id){
        return CategoriaResponse.de(categoriaService.buscar(lojaId, id));
    }


}
