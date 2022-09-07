package br.com.mateuslgomes.services;

import br.com.mateuslgomes.dtos.ReceitaDto;
import br.com.mateuslgomes.interfaces.Metodos;
import br.com.mateuslgomes.model.Categoria;
import br.com.mateuslgomes.model.Receitas;
import br.com.mateuslgomes.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DespesasServices implements Metodos {

    private final CategoriaRepository categoriaRepository;

    @Override
    public Object save(ReceitaDto dto, UriComponentsBuilder builder) {
        return null;
    }

    @Override
    public Object update(Long id, ReceitaDto dto) {
        return null;
    }

    @Override
    public Object delete(Long id) {
        return null;
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Object update(Receitas receita, ReceitaDto dto) {
        return null;
    }
}
