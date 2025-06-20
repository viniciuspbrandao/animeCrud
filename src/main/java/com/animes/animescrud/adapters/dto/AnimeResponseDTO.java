package com.animes.animescrud.adapters.dto;

import com.animes.animescrud.adapters.dto.enums.TipoGeneroDTO;
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
public class AnimeResponseDTO {

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
    private TipoGeneroDTO tipoGenero;

}