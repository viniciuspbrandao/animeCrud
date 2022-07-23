package com.animes.animescrud.domain.service;

import com.animes.animescrud.domain.domain.Anime;
import com.animes.animescrud.domain.port.AnimeRepository;
import lombok.extern.slf4j.Slf4j;


import java.util.List;

@Slf4j
public class AnimeService {
    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<Anime> getAnime() {
        try {
            return this.animeRepository.getAnime();
        } catch (Exception e) {
            log.error("Error when trying to GET an anime.", e);
            throw e;
        }

    }

    public Anime getAnimeById(Long id){
        try {
            return this.animeRepository.getAnimeById(id);
        } catch (Exception e) {
            log.error("Error when trying to GetById an anime.", e);
            throw e;
        }

    }

    public Anime addAnime (Anime anime){
        try {
            return this.animeRepository.addAnime(anime);
        } catch (Exception e) {
            log.error("Error when trying to save an anime.", anime, e);
            throw e;
        }

    }

    public Anime updateAnime(Long id, Anime anime) {
        try {
            return this.animeRepository.updateAnime(id, anime);
        } catch (Exception e) {
            log.error("The anime doesn't exist", e);
            throw e;
        }
    }

    public void deletarAnime(Long id) {
        try {
            this.animeRepository.deleteAnime(id);
        } catch (Exception e) {
            log.error("The anime doesn't exist", e);
            throw e;
        }
    }
}