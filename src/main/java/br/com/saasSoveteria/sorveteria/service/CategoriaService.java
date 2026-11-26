package br.com.saasSoveteria.sorveteria.service;

import java.util.List;

import br.com.saasSoveteria.sorveteria.exception.RecursoNaoEncontradoException;
import br.com.saasSoveteria.sorveteria.exception.RegraDeNegocioException;
import br.com.saasSoveteria.sorveteria.model.Categoria;
import br.com.saasSoveteria.sorveteria.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {

    private static final int NOME_MAX = 60;

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional(readOnly = true)
    public List<Categoria> listar(Long lojaId) {
        return categoriaRepository.findByLojaId(lojaId);
    }

    @Transactional
    public Categoria criar(Long lojaId, String nome) {
        String limpo = validarNome(nome);
        if (categoriaRepository.existsByLojaIdAndNomeIgnoreCase(lojaId, limpo)) {
            throw new RegraDeNegocioException("Já existe uma categoria com esse nome.");
        }
        return categoriaRepository.save(new Categoria(lojaId, limpo));
    }

    private String validarNome(String nome) {
        String limpo = nome == null ? "" : nome.trim();
        if (limpo.isEmpty()) {
            throw new RegraDeNegocioException("O nome da categoria é obrigatório.");
        }
        if (limpo.length() > NOME_MAX) {
            throw new RegraDeNegocioException("O nome pode ter no máximo " + NOME_MAX + " caracteres.");
        }
        return limpo;
    }
    @Transactional(readOnly = true)
    public Categoria buscar(Long id, Long lojaId) {
        return categoriaRepository.findByIdAndLojaId(id, lojaId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada."));
    }
}