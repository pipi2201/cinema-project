package com.cinema.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class ScreenedMovieEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "hallId")
    private HallEntity hall;
    @Id
    @ManyToOne
    @JoinColumn(name = "movieId")
    private MovieEntity movie;
    @Id
    private LocalDateTime screenTime;
}
