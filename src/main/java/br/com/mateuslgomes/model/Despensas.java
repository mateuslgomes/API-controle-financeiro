package br.com.mateuslgomes.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity @Table(name = "despesas")
public class Despensas {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty @NotNull @NotBlank
    private String descricao;

    @NotNull
    private BigDecimal valor;

    private LocalDateTime dataReceita = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;

    public Despensas(String descricao, BigDecimal valor, Categoria categoria) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return dataReceita.format(formatter);
    }

    public Despensas(){}

    public void setData(LocalDateTime dataReceita) {
        this.dataReceita = dataReceita;
    }
}
