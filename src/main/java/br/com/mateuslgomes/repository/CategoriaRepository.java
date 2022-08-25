package br.com.mateuslgomes.repository;

import br.com.mateuslgomes.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query(value = "SELECT * FROM categoria c WHERE c.categoria = :categoria", nativeQuery = true)
    Optional<Categoria> findByCategoria(String categoria);

}
