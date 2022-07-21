package com.animes.animescrud.controller;

import com.animes.animescrud.entity.Anime;
import com.animes.animescrud.service.AnimeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/anime")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Anime inserirNovoAnime(@RequestBody Anime anime){
        return animeService.salvar(anime);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Anime> listarAnimes(){
        return animeService.ListaAnime();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAnime(@PathVariable("id") long id){
        animeService.buscarPorId(id)
                .map(anime -> {
                    animeService.removerPorId(anime.getId());
                    return Void.TYPE;
                }) .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime nao encontrado"));
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarAnime(@PathVariable("id") Long id, @RequestBody Anime anime){
        animeService.buscarPorId(id)
                .map(animeBase -> {
                    modelMapper.map(anime,animeBase);
                    animeService.salvar(animeBase);
                    return Void.TYPE;

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime nao encontrado"));
    }
}
