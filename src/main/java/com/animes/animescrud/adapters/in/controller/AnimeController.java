package com.animes.animescrud.adapters.in.controller;

import com.animes.animescrud.adapters.mapper.AnimeMapper;
import com.animes.animescrud.adapters.dto.AnimeRequestDTO;
import com.animes.animescrud.adapters.dto.AnimeResponseDTO;
import com.animes.animescrud.application.port.in.AnimeUseCase;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/animes")
@RequiredArgsConstructor
public class AnimeController {

    @Autowired
    private final AnimeUseCase animeUseCase;

    @PostMapping(path = "/new")
    public ResponseEntity<AnimeResponseDTO> saveNewAnime(@RequestBody AnimeRequestDTO body) {
        var anime = animeUseCase.addAnime(AnimeMapper.toDomain(body));
        if (nonNull(anime)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(AnimeMapper.toRepresentation(anime));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(path = "/")
    @Operation(summary = "List all anime")
    public ResponseEntity<List<AnimeResponseDTO>> listAnimes() {
        var animeList = animeUseCase.getAnime();
        var animeRepresentationList = AnimeMapper.toAnimeResponseRepresentationList(animeList);
        return ResponseEntity.ok(animeRepresentationList);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "List anime by ID")
    public ResponseEntity<AnimeResponseDTO> searchAnimeById(@PathVariable(value = "id") Long id) {
        var anime = animeUseCase.searchAnimeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(AnimeMapper.toRepresentation(anime));
    }

    @PutMapping(path = "/{id}")
    @Operation(summary = "Update the anime")
    public ResponseEntity<AnimeResponseDTO> updateAnime(
            @PathVariable(value = "id") Long id,
            @RequestBody AnimeRequestDTO body) {

        var animeUpdated = animeUseCase.updateAnime(id, AnimeMapper.toDomain(body));

        return ResponseEntity.status(HttpStatus.CREATED).body(AnimeMapper.toRepresentation(animeUpdated));

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete the anime")
    public ResponseEntity<?> removeAnime(@PathVariable(value = "id") Long id) {
        animeUseCase.deleteAnime(id);
        return ResponseEntity.ok().build();
    }
}

