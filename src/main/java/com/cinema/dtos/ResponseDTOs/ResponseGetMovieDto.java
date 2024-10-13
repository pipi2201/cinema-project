package com.cinema.dtos.ResponseDTOs;

import com.cinema.enums.MovieVersion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGetMovieDto {
    private int movieId;
    private String title;
    private String mainCharacter;
    private String description;
    private LocalDate premieredAt;
    private MovieVersion movieVersion;
    private int hallId;
}
