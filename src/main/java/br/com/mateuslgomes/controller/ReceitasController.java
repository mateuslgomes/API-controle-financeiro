package br.com.mateuslgomes.controller;

import br.com.mateuslgomes.controller.dto.ReceitaDto;
import br.com.mateuslgomes.model.Receitas;
import br.com.mateuslgomes.repository.ReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitasController {

    @Autowired
    ReceitasRepository receitasRepository;

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
