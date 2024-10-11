package com.cinema.controller;

import com.cinema.dtos.RequestDTOs.CreateMovieDto;
import com.cinema.dtos.ResponseDTOs.ResponseCreateMovieDto;
import com.cinema.services.MovieServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movie")
@AllArgsConstructor
public class MovieController {
    MovieServices movieServices;

    @PostMapping
    public ResponseCreateMovieDto createMovie(CreateMovieDto createMovieDto) {
        return movieServices.createMovie(createMovieDto);
    }
}
