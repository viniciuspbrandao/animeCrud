package com.animes.animescrud.adapters.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeJpa extends JpaRepository<AnimeEntity, Long> {
}
