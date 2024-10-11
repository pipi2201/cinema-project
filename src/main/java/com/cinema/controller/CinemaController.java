package com.cinema.controller;

import com.cinema.dtos.RequestDTOs.CreateCinemaDto;
import com.cinema.dtos.ResponseDTOs.ResponseCreateCinemaDto;
import com.cinema.dtos.ResponseDTOs.ResponseGetCinemaDto;
import com.cinema.services.CinemaServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/cinema")
public class CinemaController {
    public CinemaServices cinemaServices;

    @PostMapping
    public ResponseEntity<ResponseCreateCinemaDto> createCinema(@RequestBody CreateCinemaDto createCinemaDto) {
        return new ResponseEntity<>(cinemaServices.createCinema(createCinemaDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseGetCinemaDto>> getAllCinemas() {
        return new ResponseEntity<>(cinemaServices.getAllCinemas(), HttpStatus.OK);
    }

    @GetMapping("{cinemaId}")
    public ResponseEntity<ResponseGetCinemaDto> getCinema(@PathVariable int cinemaId) {
        return new ResponseEntity<>(cinemaServices.getCinema(cinemaId), HttpStatus.OK);
    }

    @DeleteMapping("{cinemaId}")
    public ResponseEntity<String> deleteCinema(@PathVariable int cinemaId) {
        return new ResponseEntity<>(cinemaServices.deleteCinema(cinemaId), HttpStatus.OK);
    }
}
