package com.cinema.controller;

import com.cinema.dtos.RequestDTOs.CreateHallDto;
import com.cinema.dtos.ResponseDTOs.ResponseHallDto;
import com.cinema.services.HallServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/hall")
@AllArgsConstructor
public class HallController {
    public HallServices hallServices;

    @PostMapping
    public ResponseEntity<ResponseHallDto> createHall(@RequestBody CreateHallDto createHallDto) {
        return new ResponseEntity<>(hallServices.createHall(createHallDto), HttpStatus.CREATED);
    }

    @GetMapping("{hallId}")
    public ResponseEntity<ResponseHallDto> getHall(@PathVariable int hallId) {
        return new ResponseEntity<>(hallServices.getHall(hallId), HttpStatus.OK);
    }
}
