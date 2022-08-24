package br.com.mateuslgomes.controller.dto;

import br.com.mateuslgomes.model.Despensas;

import java.math.BigDecimal;

public class DespensaDto {

    private String descricao;

    private BigDecimal valor;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Despensas gerarDespensa() {
        return new Despensas(this.descricao, this.getValor());
    }
}
