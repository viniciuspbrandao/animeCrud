package com.animes.animescrud.adapters.dto.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoGeneroDTO {

    SHOUJO("Shoujo"),
    SEINEN("Seinen"),
    JOSEI("Josei"),
    HAREM("Harem"),
    ISEKAI("Isekai"),
    MECHA("Mecha");

    private final String tipo;

}