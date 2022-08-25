package br.com.mateuslgomes.controller;

import br.com.mateuslgomes.controller.dto.DespensaDto;
import br.com.mateuslgomes.controller.dto.ReceitaDto;
import br.com.mateuslgomes.model.Despensas;
import br.com.mateuslgomes.repository.CategoriaRepository;
import br.com.mateuslgomes.repository.DespensasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/despesas")
public class DespesasController {

    @Autowired
    DespensasRepository despensasRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @RequestMapping(path = "{id}")
    public ResponseEntity<Despensas> despensa(@PathVariable Long id) {
        Optional<Despensas> receita = despensasRepository.findById(id);
        return receita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Despensas> updateDespensa(@PathVariable Long id, @RequestBody @Valid ReceitaDto dto) {
        Despensas despensa = dto.update(despensasRepository, id);
        if (despensa != null) {
            despensasRepository.save(despensa);
            return ResponseEntity.ok(despensa);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Despensas> deleteDespensa(@PathVariable Long id) {
        Optional<Despensas> despensa = despensasRepository.findById(id);
        if (despensa.isPresent()) {
            despensasRepository.delete(despensa.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<Despensas> saveDespensa(@RequestBody @Valid DespensaDto dto, UriComponentsBuilder uriBuilder) {
        try {
            Despensas despensa = dto.gerarDespensa(categoriaRepository);
            despensasRepository.save(despensa);
            URI uri = uriBuilder.path("/despesas").buildAndExpand(despensa.getId()).toUri();
            return ResponseEntity.created(uri).body(despensa);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping
    public List<Despensas> receitas() {
        return despensasRepository.findAll();
    }
}
