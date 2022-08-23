package br.com.mateuslgomes.controller;

import br.com.mateuslgomes.controller.dto.ReceitaDto;
import br.com.mateuslgomes.model.Receitas;
import br.com.mateuslgomes.repository.ReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receitas")
public class ReceitasController {

    @Autowired
    ReceitasRepository receitasRepository;

    @RequestMapping(path = "{id}")
    public ResponseEntity<Receitas> receita(@PathVariable Long id) {
        Optional<Receitas> receita = receitasRepository.findById(id);
        return receita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Receitas> deleteReceita(@PathVariable Long id) {
        Optional<Receitas> receita = receitasRepository.findById(id);
        if (receita.isPresent()) {
            receitasRepository.delete(receita.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Receitas> updateReceita(@PathVariable Long id, @RequestBody @Valid ReceitaDto dto) {
        Receitas receita = dto.update(receitasRepository, id);
        if (receita != null) {
            receitasRepository.save(receita);
            return ResponseEntity.ok(receita);
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping
    public List<Receitas> receitas() {
        return receitasRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Receitas> saveReceita(@RequestBody @Valid ReceitaDto dto, UriComponentsBuilder uriBuilder) {
        try {
            Receitas receitas = dto.gerarReceita();
            receitasRepository.save(receitas);
            URI uri = uriBuilder.path("/receitas").buildAndExpand(receitas.getId()).toUri();
            return ResponseEntity.created(uri).body(receitas);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
