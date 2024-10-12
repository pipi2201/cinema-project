package com.cinema.entities.pk;

import com.cinema.entities.HallEntity;
import com.cinema.entities.MovieEntity;
import com.cinema.entities.ScreenedMovieEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ScreenedMoviePk implements Serializable {
    private HallEntity hall;
    private MovieEntity movie;
    private LocalDateTime screenTime;
}
