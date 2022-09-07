package br.com.mateuslgomes.dtos;

import br.com.mateuslgomes.model.Categoria;
import br.com.mateuslgomes.model.Despensas;
import br.com.mateuslgomes.repository.CategoriaRepository;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
public class DespensaDto {
    private String descricao;

    private BigDecimal valor;

    private String categoria;

    public final static String CATEGORIA_OUTRAS = "Outras";

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
