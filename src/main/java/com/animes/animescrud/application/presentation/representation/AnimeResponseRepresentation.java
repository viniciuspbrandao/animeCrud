package com.animes.animescrud.application.presentation.representation;

import com.animes.animescrud.application.presentation.representation.enums.TipoGeneroRepresentation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnimeResponseRepresentation {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("author")
    private String author;

    @JsonProperty("yearPublication")
    private int yearPublication;

    @JsonProperty("episodesNumber")
    private int episodesNumber;

    @JsonProperty("synopsis")
    private String synopsis;

    @JsonProperty("tipoGenero")
    private TipoGeneroRepresentation tipoGenero;

}