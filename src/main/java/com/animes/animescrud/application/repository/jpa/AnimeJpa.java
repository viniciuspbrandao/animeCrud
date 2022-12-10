package com.animes.animescrud.application.repository.jpa;

import com.animes.animescrud.application.repository.jpa.entity.AnimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeJpa extends JpaRepository<AnimeEntity, Long> {
}
