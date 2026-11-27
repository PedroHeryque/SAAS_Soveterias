package br.com.saasSoveteria.sorveteria.service;

import br.com.saasSoveteria.sorveteria.exception.RecursoNaoEncontradoException;
import br.com.saasSoveteria.sorveteria.exception.RegraDeNegocioException;
import br.com.saasSoveteria.sorveteria.model.Complemento;
import br.com.saasSoveteria.sorveteria.model.Loja;
import br.com.saasSoveteria.sorveteria.repository.ComplementosRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ComplementosService {

    private static final int MAX_NOME = 60;

    private ComplementosRepository complementosRepository;

    public ComplementosService(ComplementosRepository complementosRepository) {
        this.complementosRepository = complementosRepository;
    }

    @Transactional(readOnly = true)
    public List<Complemento> listar(Long lojaId) {
        return complementosRepository.findByLojaId(lojaId);
    }

    @Transactional(readOnly = true)
    public Complemento buscar(Long id, Long lojaId) {
        return complementosRepository.findByIdAndLojaId(id, lojaId).orElseThrow(
                () -> new RecursoNaoEncontradoException("Complemento não encontrado."));
    }

    @Transactional
    public Complemento criar(String nome, Long lojaId) {
        String limpo = validarNome(nome);
        if (complementosRepository.existsByLojaIdAndNomeIgnoreCase(lojaId, limpo)) {
            throw new RegraDeNegocioException("Já existe um complemento com esse nome.");
        }
        return complementosRepository.save(new Complemento(lojaId, limpo));
    }

    private String validarNome(String nome) {
        String limpo = nome == null ? "" : nome.trim();
        if (limpo.isEmpty()) {
            throw new RegraDeNegocioException("O nome do complemento é obrigatório.");
        }
        if (limpo.length() > MAX_NOME) {
            throw new RegraDeNegocioException("O nome pode ter no máximo " + MAX_NOME + " caracteres.");
        }
        return limpo;
    }

}
