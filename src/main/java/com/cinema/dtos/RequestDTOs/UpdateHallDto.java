package com.cinema.dtos.RequestDTOs;

import com.cinema.enums.MovieVersion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHallDto {
    private int capacity;
    private int occupiedSeats;
    private MovieVersion supportedMovieVersion;
}
