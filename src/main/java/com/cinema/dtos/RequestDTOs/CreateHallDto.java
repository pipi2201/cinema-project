package com.cinema.dtos.RequestDTOs;

import com.cinema.enums.MovieVersion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateHallDto {
    private int capacity;
    private int occupiedSeats;
    private MovieVersion supportedMovieVersion;
    private int cinemaId;
}
