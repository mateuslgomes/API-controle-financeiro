package br.com.mateuslgomes.controller.dto;

import br.com.mateuslgomes.model.Receitas;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class ReceitaDto {

    private String descricao;

    private BigDecimal valor;

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Receitas gerarReceita() {
        return new Receitas(descricao, valor);
    }

}
