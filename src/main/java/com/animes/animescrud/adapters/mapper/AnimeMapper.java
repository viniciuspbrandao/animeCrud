package com.animes.animescrud.adapters.mapper;

import com.animes.animescrud.adapters.dto.AnimeRequestDTO;
import com.animes.animescrud.adapters.dto.AnimeResponseDTO;
import com.animes.animescrud.adapters.out.persistence.jpa.AnimeEntity;
import com.animes.animescrud.domain.model.Anime;
import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.util.Supplier;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class AnimeMapper {

    private final Supplier<ModelMapper> modelMapperSupplier = ModelMapper::new;

    public Anime toDomain(AnimeRequestDTO representation) {
        return modelMapperSupplier.get().map(representation, Anime.class);
    }

    //do domain(service) para representation(espelho do que o usuario recebe de resposta)
    public AnimeResponseDTO toRepresentation(Anime anime) {
        return modelMapperSupplier.get().map(anime, AnimeResponseDTO.class);
    }

    public AnimeEntity toEntity(Anime anime) {

        return modelMapperSupplier.get().map(anime, AnimeEntity.class);
    }

    public Anime entityToDomain(AnimeEntity entity) {

        return modelMapperSupplier.get().map(entity, Anime.class);
    }

    // do list<anime> -> Domain para list<animeResponseRepresentation> -> Representation
    public List<AnimeResponseDTO> toAnimeResponseRepresentationList(List<Anime> animeList) {
        List<AnimeResponseDTO> animeRepresentationList = new ArrayList<>();
        for (Anime anime : animeList) {
            animeRepresentationList.add(toRepresentation(anime));
        }
        return animeRepresentationList;
    }

    public List<Anime> toDomainList(List<AnimeEntity> animeEntityList) {
        List<Anime> animeList = new ArrayList<>();
        for (AnimeEntity animeEntity : animeEntityList) {
            animeList.add(entityToDomain(animeEntity));
        }
        return animeList;
    }
}