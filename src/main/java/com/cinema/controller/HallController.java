package com.cinema.controller;

import com.cinema.dtos.RequestDTOs.CreateHallDto;
import com.cinema.dtos.ResponseDTOs.ResponseHallDto;
import com.cinema.services.HallServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hall")
@AllArgsConstructor
public class HallController {
    public HallServices hallServices;

    @PostMapping
    public ResponseEntity<ResponseHallDto> createHall(@RequestBody CreateHallDto createHallDto) {
        return new ResponseEntity<>(hallServices.createHall(createHallDto), HttpStatus.CREATED);
    }
}
