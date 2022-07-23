package com.animes.animescrud.application.mapper;

import com.animes.animescrud.application.presentation.representation.AnimeRequestRepresentation;
import com.animes.animescrud.application.presentation.representation.AnimeResponseRepresentation;
import com.animes.animescrud.application.repository.jpa.entity.AnimeEntity;
import com.animes.animescrud.domain.domain.Anime;
import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.util.Supplier;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class AnimeMapper {

    private final Supplier<ModelMapper> modelMapperSupplier = ModelMapper::new;

    public Anime paraDominio(AnimeRequestRepresentation representation) {
        return modelMapperSupplier.get().map(representation, Anime.class);
    }

    public AnimeResponseRepresentation paraRepresentacao(Anime anime){
        return modelMapperSupplier.get().map(anime, AnimeResponseRepresentation.class);
    }

    public AnimeEntity paraEntity(Anime anime) {
        return modelMapperSupplier.get().map(anime, AnimeEntity.class);
    }

    public Anime entityParaDominio(AnimeEntity entity) {
        return modelMapperSupplier.get().map(entity, Anime.class);
    }

    public List<AnimeResponseRepresentation> toAnimeResponseRepresentationList(List<Anime> animeList) {
        List<AnimeResponseRepresentation> animeRepresentationList = new ArrayList<>();
        for (Anime anime : animeList) {
            animeRepresentationList.add(paraRepresentacao(anime));
        }
        return animeRepresentationList;
    }
    public List<Anime> toDomainList(List<AnimeEntity> animeEntityList) {
        List<Anime> animeList = new ArrayList<>();
        for (AnimeEntity animeEntity : animeEntityList) {
            animeList.add(entityParaDominio(animeEntity));
        }
        return animeList;
    }
}