package com.animes.animescrud.domain.domain;

import com.animes.animescrud.domain.enums.TipoGenero;

public class Anime {

    private Long id;
    private String name;
    private String author;
    private int yearPublication;
    private int episodesNumber;
    private String synopsis;
    private TipoGenero tipoGenero;

    public Anime() {
    }

    public Anime(Long id, String name, String author, int yearPublication, int episodesNumber, String synopsis, TipoGenero tipoGenero) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.yearPublication = yearPublication;
        this.episodesNumber = episodesNumber;
        this.synopsis = synopsis;
        this.tipoGenero = tipoGenero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public int getEpisodesNumber() {
        return episodesNumber;
    }

    public void setEpisodesNumber(int episodesNumber) {
        this.episodesNumber = episodesNumber;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public TipoGenero getTipoGenero() {
        return tipoGenero;
    }

    public void setTipoGenero(TipoGenero tipoGenero) {
        this.tipoGenero = tipoGenero;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", yearPublication=" + yearPublication +
                ", episodesNumber=" + episodesNumber +
                ", synopsis='" + synopsis + '\'' +
                ", tipoGenero=" + tipoGenero +
                '}';
    }
}