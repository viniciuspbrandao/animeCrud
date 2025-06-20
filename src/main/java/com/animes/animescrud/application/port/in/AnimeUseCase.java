package com.animes.animescrud.application.port.in;

import com.animes.animescrud.domain.model.Anime;

import java.util.List;

public interface AnimeUseCase {

    List<Anime> getAnime();

    Anime searchAnimeById(Long id);
    Anime addAnime(Anime anime);
    Anime updateAnime(Long id, Anime anime);

    void deleteAnime(Long id);
}
