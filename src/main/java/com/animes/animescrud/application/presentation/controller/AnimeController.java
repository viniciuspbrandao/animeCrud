package com.animes.animescrud.application.presentation.controller;

import com.animes.animescrud.application.mapper.AnimeMapper;
import com.animes.animescrud.application.presentation.representation.AnimeRequestRepresentation;
import com.animes.animescrud.application.presentation.representation.AnimeResponseRepresentation;
import com.animes.animescrud.domain.service.AnimeService;
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
    private AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }


    @PostMapping(path = "/salvar")
    public ResponseEntity<AnimeResponseRepresentation> inserirNovoAnime(@RequestBody AnimeRequestRepresentation body) {
        var anime = animeService.addAnime(AnimeMapper.paraDominio(body));
        if (nonNull(anime)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(AnimeMapper.paraRepresentacao(anime));
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping(path = "/listarAnimes")
    public ResponseEntity<List<AnimeResponseRepresentation>> listarAnimes(){
        var animeList = animeService.getAnime();
        var animeRepresentationList = AnimeMapper.toAnimeResponseRepresentationList(animeList);
        return  ResponseEntity.ok(animeRepresentationList);
    }

    @GetMapping(path ="/{id}")
    public ResponseEntity<AnimeResponseRepresentation> getAnimeById(@PathVariable(value = "id") Long id){
        var anime = animeService.getAnimeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(AnimeMapper.paraRepresentacao(anime));
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<AnimeResponseRepresentation> atualizarAnime(
            @PathVariable(value = "id") Long id,
            @RequestBody AnimeRequestRepresentation body) {

        var animeUpdated = animeService.updateAnime(id, AnimeMapper.paraDominio(body));

        return ResponseEntity.status(HttpStatus.CREATED).body(AnimeMapper.paraRepresentacao(animeUpdated));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAnime(@PathVariable(value = "id") Long id) {
        animeService.deletarAnime(id);
        return ResponseEntity.ok().build();
    }

}

