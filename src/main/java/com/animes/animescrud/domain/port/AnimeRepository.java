package com.animes.animescrud.domain.port;


import com.animes.animescrud.domain.domain.Anime;

import java.util.List;

public interface AnimeRepository {

    List<Anime> getAnime();

    Anime getAnimeById(Long id);
    Anime addAnime(Anime anime);
    Anime updateAnime(Long id, Anime anime);

    void deleteAnime(Long id);


}