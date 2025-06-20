package com.animes.animescrud.adapters.out.persistence.jpa;

import com.animes.animescrud.domain.model.TipoGenero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_anime")
public class AnimeEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "author", nullable = false, length = 50)
    private String author;

    @Column(name = "year_publication")
    private int yearPublication;

    @Column(name = "episodes_number")
    private int episodesNumber;

    @Column(name = "synopsis", columnDefinition = "TEXT")
    private String synopsis;

    @Enumerated(EnumType.STRING)
    private TipoGenero tipoGenero;

    @Column(name = "insert_date_time")
    private LocalDateTime insertDateTime;

    @Column(name = "update_date_time")
    private LocalDateTime updateDateTime;

    @PrePersist
    public void prePersist() {
        insertDateTime = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateDateTime = LocalDateTime.now();
    }

}
