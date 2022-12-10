package com.animes.animescrud.domain.domain;


import com.animes.animescrud.domain.enums.TipoGenero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Anime {

    private Long id;
    private String name;
    private String author;
    private int yearPublication;
    private int episodesNumber;
    private String synopsis;
    private TipoGenero tipoGenero;

}