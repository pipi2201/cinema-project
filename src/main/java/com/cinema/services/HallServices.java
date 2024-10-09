package com.cinema.services;

import com.cinema.dtos.RequestDTOs.CreateHallDto;
import com.cinema.dtos.ResponseDTOs.ResponseHallDto;
import com.cinema.entities.CinemaEntity;
import com.cinema.entities.HallEntity;
import com.cinema.repositories.HallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HallServices {
    private final CinemaServices cinemaServices;
    private final HallRepository hallRepository;

    public ResponseHallDto createHall(CreateHallDto createHallDto) {
        HallEntity hallEntity = new HallEntity();
        hallEntity.setCapacity(createHallDto.getCapacity());
        hallEntity.setOccupiedSeats(createHallDto.getOccupiedSeats());
        hallEntity.setSupportedMovieVersion(createHallDto.getSupportedMovieVersion());
        hallEntity.setCinema(cinemaServices.getCinemaById(createHallDto.getCinemaId()));

        hallRepository.save(hallEntity);

        return new ResponseHallDto(
                hallEntity.getHallId(),
                hallEntity.getCapacity(),
                hallEntity.getOccupiedSeats(),
                hallEntity.getSupportedMovieVersion(),
                hallEntity.getCinema().getCinemaId()
        );
    }
}
