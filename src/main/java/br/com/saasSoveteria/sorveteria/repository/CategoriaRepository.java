package br.com.saasSoveteria.sorveteria.repository;

import java.util.List;
import java.util.Optional;

import br.com.saasSoveteria.sorveteria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByLojaId(Long lojaId);

    Optional<Categoria>findByIdAndLojaId(Long id,Long lojaId);
}
