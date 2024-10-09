package com.cinema.controller;

import com.cinema.dtos.RequestDTOs.CreateCinemaDto;
import com.cinema.dtos.ResponseDTOs.ResponseCinemaDto;
import com.cinema.services.CinemaServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/cinema")
public class CinemaController {
    public CinemaServices cinemaServices;

    @PostMapping
    public ResponseEntity<ResponseCinemaDto> createCinema(@RequestBody CreateCinemaDto createCinemaDto) {
        return new ResponseEntity<>(cinemaServices.createCinema(createCinemaDto), HttpStatus.CREATED);
    }
}
