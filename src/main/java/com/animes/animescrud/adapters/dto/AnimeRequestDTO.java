package com.animes.animescrud.adapters.dto;

import com.animes.animescrud.adapters.dto.enums.TipoGeneroDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class AnimeRequestDTO {

    @JsonProperty("name")
    @Schema(description = "Anime Name", example = "Dragon Ball")
    private String name;

    @JsonProperty("author")
    @Schema(description = "Anime Author", example = "Akira Toriyama")
    private String author;

    @JsonProperty("yearPublication")
    @Schema(description = "Anime Publication Year", example = "1984")
    private int yearPublication;

    @JsonProperty("episodesNumber")
    @Schema(description = "Number of episodes", example = "153")
    private int episodesNumber;

    @JsonProperty("synopsis")
    @Schema(description = "Anime Synopsis", example = "The story of Goku")
    private String synopsis;

    @JsonProperty("genre")
    @Schema(description = "Anime Genre", example = "SEINEN")
    private TipoGeneroDTO tipoGenero;

}