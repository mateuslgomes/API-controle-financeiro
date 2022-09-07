package br.com.mateuslgomes.services;

import br.com.mateuslgomes.dtos.ReceitaDto;
import br.com.mateuslgomes.interfaces.Metodos;
import br.com.mateuslgomes.model.Receitas;
import br.com.mateuslgomes.repository.ReceitasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReceitaServices implements Metodos {

    private final ReceitasRepository receitasRepository;

    public Receitas gerar(ReceitaDto dto) {
        return new Receitas(dto.getDescricao(), dto.getValor());
    }

    @Override
    public ResponseEntity<Receitas> save(ReceitaDto dto, UriComponentsBuilder builder) {
        Receitas receita = gerar(dto);
        try {
            receitasRepository.save(receita);
            URI uri = builder.path("/receitas").buildAndExpand(receita.getId()).toUri();
            return ResponseEntity.created(uri).body(receita);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public Receitas update(Receitas receita, ReceitaDto dto) {
            receita.setValor(dto.getValor());
            receita.setDescricao(dto.getDescricao());
            receita.setDataReceita(dto.getDataReceita());
            return receita;
        }

    @Override
    public ResponseEntity<Receitas> delete(Long id) {
        Optional<Receitas> receita = findById(id);
        if (receita.isPresent()) {
            receitasRepository.delete(receita.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }


    @Override
    public ResponseEntity<Receitas> update(Long id, ReceitaDto dto) {
        return findById(id).map(receitas -> ResponseEntity.ok(receitasRepository.save(update(receitas, dto))
        )).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Override
    public Optional<Receitas> findById(Long id) {
        return receitasRepository.findById(id);
    }
}
