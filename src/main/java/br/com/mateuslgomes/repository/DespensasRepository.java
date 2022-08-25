package br.com.mateuslgomes.repository;

import br.com.mateuslgomes.model.Despensas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespensasRepository extends JpaRepository<Despensas, Long> {
    @Query(value = "SELECT * FROM despesas d WHERE d.descricao = :descricao", nativeQuery = true)
    List<Despensas> findByDescricao(String descricao);
}
