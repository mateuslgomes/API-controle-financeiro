package br.com.mateuslgomes.model;

public enum CategoriasEnum {
    Alimentação("Alimentação"),
    Saúde("Saúde"),
    Moradia("Moradia"),
    Transporte("Transporte"),
    Educação("Educação"),
    Lazer("Lazer"),
    Imprevistos("Imprevistos"),
    Outras("Outras");

    private String categoria;
    CategoriasEnum(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
}
