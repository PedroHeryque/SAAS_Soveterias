package br.com.saasSoveteria.sorveteria.repository;


import br.com.saasSoveteria.sorveteria.model.Complemento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComplementosRepository extends JpaRepository<Complemento, Long> {
    List<Complemento>findByLojaId(Long lojaId);

    Optional<Complemento>findByIdAndLojaId(Long id,Long lojaId);

    boolean existsByLojaIdAndNomeIgnoreCase(Long lojaId, String nome);
    boolean existsByLojaIdAndNomeIgnoreCaseAndIdNot(Long lojaId, Long id);
}
