package com.animes.animescrud.application.repository;

import com.animes.animescrud.application.mapper.AnimeMapper;
import com.animes.animescrud.application.repository.jpa.AnimeJpa;
import com.animes.animescrud.domain.domain.Anime;
import com.animes.animescrud.domain.port.AnimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AnimeRepositoryImpl implements AnimeRepository {

    private final AnimeJpa animeJpa;

    @Override
    public List<Anime> getAnime() {
        try {
            var animeEntity = animeJpa.findAll();
            return AnimeMapper.toDomainList(animeEntity);
        } catch (Exception e) {
            log.error("Error when trying to get an anime.", e);
            throw e;
        }
    }

    @Override
    public Anime getAnimeById(Long id) {
        var animeEntity = animeJpa.findById(id);
        if (animeEntity.isPresent()) {

            return AnimeMapper.entityToDomain(animeEntity.get());
        }
        return null;

    }

    @Override
    public Anime addAnime(Anime anime) {
        try {
            var animeEntity = animeJpa.save(AnimeMapper.toEntity(anime));
            return AnimeMapper.entityToDomain(animeEntity);
        } catch (Exception e) {
            log.error("Error when trying to save an anime.", anime, e);
            throw e;
        }
    }

    @Override
    public Anime updateAnime(Long id, Anime anime) throws HttpStatusCodeException {
        var animeEntityById = animeJpa.findById(id);

        if (animeEntityById.isPresent()) {
            anime.setId(animeEntityById.get().getId());
            var animeEntity = animeJpa.save(AnimeMapper.toEntity(anime));
            return AnimeMapper.entityToDomain(animeEntity);
        }

        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Anime doesn't exist");
    }

    @Override
    public void deleteAnime(Long id) throws HttpStatusCodeException {
        var animeToDelete = getAnimeById(id);

        if (animeToDelete != null) {
            animeJpa.deleteById(id);
        } else {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Anime doesn't exist");
        }
    }


}