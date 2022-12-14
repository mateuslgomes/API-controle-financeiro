package br.com.mateuslgomes.dtos;

import br.com.mateuslgomes.model.Despensas;
import br.com.mateuslgomes.model.Receitas;
import br.com.mateuslgomes.repository.DespensasRepository;
import br.com.mateuslgomes.repository.ReceitasRepository;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Getter
public class ReceitaDto {

    private String descricao;

    private BigDecimal valor;

    private final LocalDateTime dataReceita = LocalDateTime.now();

    public Receitas update(ReceitasRepository receitasRepository, Long id) {
        Optional<Receitas> receitaOptiontal = receitasRepository.findById(id);
        if (receitaOptiontal.isPresent()) {
            Receitas receita = receitaOptiontal.get();
            receita.setValor(this.valor);
            receita.setDescricao(this.descricao);
            receita.setDataReceita(dataReceita);
            return receita;
        }
        return null;
    }

    public Despensas update(DespensasRepository despensasRepository, Long id) {
        Optional<Despensas> despensasOptional = despensasRepository.findById(id);
        if (despensasOptional.isPresent()) {
            Despensas despensas  = despensasOptional.get();
            despensas.setValor(this.valor);
            despensas.setDescricao(this.descricao);
            despensas.setData(dataReceita);
            return despensas;
        }
        return null;
    }
}

