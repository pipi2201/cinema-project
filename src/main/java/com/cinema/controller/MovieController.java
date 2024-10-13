package com.cinema.controller;

import com.cinema.dtos.RequestDTOs.CreateMovieDto;
import com.cinema.dtos.ResponseDTOs.ResponseCreateMovieDto;
import com.cinema.dtos.ResponseDTOs.ResponseGetMovieDto;
import com.cinema.services.MovieServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movie")
@AllArgsConstructor
public class MovieController {
    private final MovieServices movieServices;

    @PostMapping
    public ResponseEntity<ResponseCreateMovieDto> createMovie(@RequestBody CreateMovieDto createMovieDto) {
        return new ResponseEntity<>(movieServices.createMovie(createMovieDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseGetMovieDto>> getMovies() {
        return new ResponseEntity<>(movieServices.getMovies(), HttpStatus.OK);
    }
}
