package br.com.mateuslgomes.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name = "despesas")
public class Despensas {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty @NotNull @NotBlank
    private String descricao;

    @NotNull
    private BigDecimal valor;

    private LocalDateTime dataReceita = LocalDateTime.now();

    public Despensas(String descricao, BigDecimal valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public Despensas(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return dataReceita;
    }

    public void setData(LocalDateTime data) {
        this.dataReceita = data;
    }

    public void setDataReceita(LocalDateTime dataReceita) {
        this.dataReceita = dataReceita;
    }
}
