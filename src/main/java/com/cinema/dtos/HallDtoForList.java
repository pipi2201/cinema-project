package com.cinema.dtos;

import com.cinema.entities.ScreenedMovieEntity;
import com.cinema.enums.MovieVersion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HallDtoForList {
    private int hallId;
    private int capacity;
    private int occupiedSeats;
    private MovieVersion supportedMovieVersion;
    private int cinemaId;
}
