package com.animes.animescrud.domain.model;

public enum TipoGenero {

    SHOUJO("Shoujo"),
    SEINEN("Seinen"),
    JOSEI("Josei"),
    HAREM("Harem"),
    ISEKAI("Isekai"),
    MECHA("Mecha");


    private final String tipo;

    TipoGenero(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
