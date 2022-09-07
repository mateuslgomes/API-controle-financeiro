package br.com.mateuslgomes.repository;

import br.com.mateuslgomes.dtos.ReceitaDto;
import br.com.mateuslgomes.model.Receitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitasRepository extends JpaRepository<Receitas, Long> {

    @Query(value = "SELECT * FROM receitas r WHERE r.descricao LIKE :descricao%", nativeQuery = true)
    List<Receitas> findByDescricao(String descricao);

}
