package com.cinema.dtos.ResponseDTOs;

import com.cinema.entities.CinemaEntity;
import com.cinema.entities.ScreenedMovieEntity;
import com.cinema.enums.MovieVersion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHallDto {
    private int hallId;
    private int capacity;
    private int occupiedSeats;
    private MovieVersion supportedMovieVersion;
    private int cinemaId;
}
