package com.cinema.dtos.RequestDTOs;

import com.cinema.enums.MovieVersion;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMovieDto {
    private String title;
    private String mainCharacter;
    private String description;
    private LocalDate premieredAt;
    private MovieVersion movieVersion;
}
