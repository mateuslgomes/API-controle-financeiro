package br.com.mateuslgomes.controller.dto;

import br.com.mateuslgomes.model.Receitas;
import br.com.mateuslgomes.repository.ReceitasRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class ReceitaDto {

    private String descricao;

    private BigDecimal valor;

    private final LocalDateTime dataReceita = LocalDateTime.now();

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Receitas gerarReceita() {
        return new Receitas(descricao, valor);
    }

    public Receitas update(ReceitasRepository receitasRepository, Long id) {
        Optional<Receitas> receitaOptiontal = receitasRepository.findById(id);
        Receitas receita = receitaOptiontal.get();
        receita.setValor(this.valor);
        receita.setDescricao(this.descricao);
        receita.setDataReceita(dataReceita);
        return receita;
    }
}
