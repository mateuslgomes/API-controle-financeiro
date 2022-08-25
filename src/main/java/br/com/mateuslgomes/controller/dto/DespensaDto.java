package br.com.mateuslgomes.controller.dto;

import br.com.mateuslgomes.model.Categoria;
import br.com.mateuslgomes.model.Despensas;
import br.com.mateuslgomes.repository.CategoriaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public class DespensaDto {

    private String descricao;

    private BigDecimal valor;

    private String categoria;

    public String getCategoria() {
        return categoria;
    }

    public final static String CATEGORIA_OUTRAS = "Outras";

    public void setCategoriaId(String categoria) {
        this.categoria = categoria;
    }

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
    public Despensas gerarDespensa(CategoriaRepository categoriaRepository) {
        if (categoria == null) {
            Optional<Categoria> categoriaOptional = categoriaRepository.findByCategoria(categoria);
            return new Despensas(this.descricao, this.valor, categoriaOptional.get());
        }
        Optional<Categoria> categoriaOptional = categoriaRepository.findByCategoria(categoria);
        return new Despensas(this.descricao, this.valor, categoriaOptional.get());
    }
}
