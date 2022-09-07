package br.com.mateuslgomes.interfaces;

import br.com.mateuslgomes.dtos.ReceitaDto;
import br.com.mateuslgomes.model.Receitas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

public interface Metodos {

    public Object save(ReceitaDto dto, UriComponentsBuilder builder);

    public Object update(Long id, ReceitaDto dto);

    public Object delete(Long id);

    public Object findById(Long id);

    public Object update(Receitas receita, ReceitaDto dto);

}
