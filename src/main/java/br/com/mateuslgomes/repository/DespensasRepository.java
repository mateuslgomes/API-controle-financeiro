package br.com.mateuslgomes.repository;

import br.com.mateuslgomes.model.Despensas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespensasRepository extends JpaRepository<Despensas, Long> {}
