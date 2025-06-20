package com.animes.animescrud.config;

import com.animes.animescrud.application.port.out.AnimeRepository;
import com.animes.animescrud.domain.service.AnimeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimeConfig {

    @Bean
    public AnimeService animeService(AnimeRepository animeRepository) {
        return new AnimeService(animeRepository);
    }

}