package br.com.mateuslgomes.services;

import br.com.mateuslgomes.dtos.ReceitaDto;
import br.com.mateuslgomes.model.Receitas;
import br.com.mateuslgomes.repository.ReceitasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReceitaServices {

    private final ReceitasRepository receitasRepository;

    public static Receitas gerarReceita(ReceitaDto dto) {
        return new Receitas(dto.getDescricao(), dto.getValor());
    }


    public Optional<Receitas> findById(Long id) {
        return receitasRepository.findById(id);
    }

    public ResponseEntity<Receitas> saveReceita(ReceitaDto dto, UriComponentsBuilder builder) {
        Receitas receita = gerarReceita(dto);
        try {
            receitasRepository.save(receita);
            URI uri = builder.path("/receitas").buildAndExpand(receita.getId()).toUri();
            return ResponseEntity.created(uri).body(receita);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Receitas> update(Long id, ReceitaDto dto) {
        return findById(id).map(receitas -> ResponseEntity.ok(receitasRepository.save(updateReceita(receitas, dto))
        )).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    private static Receitas updateReceita(Receitas receita, ReceitaDto dto) {
            receita.setValor(dto.getValor());
            receita.setDescricao(dto.getDescricao());
            receita.setDataReceita(dto.getDataReceita());
            return receita;
        }

    public ResponseEntity<Receitas> deleteReceita(Long id) {
        Optional<Receitas> receita = findById(id);
        if (receita.isPresent()) {
            receitasRepository.delete(receita.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }


}
