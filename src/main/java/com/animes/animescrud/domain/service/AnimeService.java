package com.animes.animescrud.domain.service;

import com.animes.animescrud.application.port.in.AnimeUseCase;
import com.animes.animescrud.domain.model.Anime;
import com.animes.animescrud.application.port.out.AnimeRepository;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;


public class AnimeService implements AnimeUseCase {
    private static final Logger logger = Logger.getLogger(AnimeService.class.getName());
    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<Anime> getAnime() {
        try {
            return this.animeRepository.getAnime();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error when trying to GET an anime.", e);
            throw e;
        }

    }

    public Anime searchAnimeById(Long id) {
        try {
            return this.animeRepository.getAnimeById(id);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error when trying to GetById an anime.", e);
            throw e;
        }

    }

    public Anime addAnime(Anime anime) {
        try {
            return this.animeRepository.addAnime(anime);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error when trying to save an anime.", e);
            throw e;
        }

    }

    public Anime updateAnime(Long id, Anime anime) {
        try {
            return this.animeRepository.updateAnime(id, anime);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "The anime doesn't exist", e);
            throw e;
        }
    }

    public void deleteAnime(Long id) {
        try {
            this.animeRepository.deleteAnime(id);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "The anime doesn't exist", e);
            throw e;
        }
    }
}