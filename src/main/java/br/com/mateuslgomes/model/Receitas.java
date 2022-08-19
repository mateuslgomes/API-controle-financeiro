package br.com.mateuslgomes.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity @Table(name = "receitas")
public class Receitas {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long descricao;

    private BigDecimal valor;

    private Date data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDescricao() {
        return descricao;
    }

    public void setDescricao(Long descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
