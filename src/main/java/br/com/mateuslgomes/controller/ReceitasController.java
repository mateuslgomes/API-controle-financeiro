package br.com.mateuslgomes.controller;

import br.com.mateuslgomes.dtos.ReceitaDto;
import br.com.mateuslgomes.model.Receitas;
import br.com.mateuslgomes.repository.ReceitasRepository;
import br.com.mateuslgomes.services.ReceitaServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/receitas")
public class ReceitasController {

    private final ReceitasRepository receitasRepository;

    private final ReceitaServices receitaServices;

    @RequestMapping(path = "{id}")
    public ResponseEntity<Receitas> receita(@PathVariable Long id) {
        Optional<Receitas> receita = receitasRepository.findById(id);
        return receita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(path = "{ano}/{mes}")
    public ResponseEntity<Receitas> receitaByDate(@PathVariable String ano, @PathVariable String mes) {
        return ResponseEntity.ok().build();
    }

    @RequestMapping
    public ResponseEntity<List<Receitas>> receitas(@RequestParam(required = false, value = "descricao") String descricao){
        if (descricao == null) {
            return ResponseEntity.ok(receitasRepository.findAll());
        }
        return ResponseEntity.ok(receitasRepository.findByDescricao(descricao));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Receitas> deleteReceita(@PathVariable Long id) {
        return receitaServices.delete(id);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Receitas> updateReceita(@PathVariable Long id, @RequestBody @Valid ReceitaDto dto) {
        return receitaServices.update(id, dto);
    }

    @PostMapping
    public ResponseEntity<Receitas> saveReceita(@RequestBody @Valid ReceitaDto dto, UriComponentsBuilder uriBuilder) {
        return receitaServices.save(dto, uriBuilder);
    }
}
