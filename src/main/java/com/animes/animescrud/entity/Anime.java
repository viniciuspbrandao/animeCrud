package com.animes.animescrud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Anime implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "anime", nullable = false)
    private String nome;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "publicacao")
    private int publicacao;

    @Column(name = "episodios")
    private int episodios;

    @Column(name = "genero", nullable = false)
    private String genero;

    @Column(name = "sinopse")
    private String sinopse;

}
