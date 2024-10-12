package com.cinema.controller;

import com.cinema.dtos.RequestDTOs.CreateMovieDto;
import com.cinema.dtos.ResponseDTOs.ResponseCreateMovieDto;
import com.cinema.services.MovieServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movie")
@AllArgsConstructor
public class MovieController {
    private final MovieServices movieServices;

    @PostMapping
    public ResponseEntity<ResponseCreateMovieDto> createMovie(@RequestBody CreateMovieDto createMovieDto) {
        return new ResponseEntity<>(movieServices.createMovie(createMovieDto), HttpStatus.CREATED);
    }
}
