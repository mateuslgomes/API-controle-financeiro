package br.com.mateuslgomes.controller;

import br.com.mateuslgomes.controller.dto.DespensaDto;
import br.com.mateuslgomes.model.Despensas;
import br.com.mateuslgomes.model.Receitas;
import br.com.mateuslgomes.repository.DespensasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/despesas")
public class DespesasController {

    @Autowired
    DespensasRepository despensasRepository;

    @PostMapping
    public ResponseEntity<Despensas> saveDespensa(@RequestBody @Valid DespensaDto dto, UriComponentsBuilder uriBuilder) {
        try {
            Despensas despensa = dto.gerarDespensa();
            despensasRepository.save(despensa);
            URI uri = uriBuilder.path("/despesas").buildAndExpand(despensa.getId()).toUri();
            return ResponseEntity.created(uri).body(despensa);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
