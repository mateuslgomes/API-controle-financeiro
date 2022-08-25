package br.com.mateuslgomes.model;

import javax.persistence.*;
import java.util.List;

@Entity @Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="categoria", nullable=false)
    private CategoriasEnum categorias;

    public Categoria() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoriasEnum getCategorias() {
        return categorias;
    }

    public void setCategorias(CategoriasEnum categorias) {
        this.categorias = categorias;
    }
}
