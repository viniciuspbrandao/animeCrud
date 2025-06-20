package com.animes.animescrud.application.port.out;

import com.animes.animescrud.domain.model.Anime;

import java.util.List;

public interface AnimeRepository {

    List<Anime> getAnime();

    Anime getAnimeById(Long id);
    Anime addAnime(Anime anime);
    Anime updateAnime(Long id, Anime anime);

    void deleteAnime(Long id);


}