package com.cinema.services;

import com.cinema.dtos.CreateCinemaDto;
import com.cinema.dtos.ResponseCinemaDto;
import com.cinema.entities.CinemaEntity;
import com.cinema.repositories.CinemaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CinemaServices {

    public CinemaRepository cinemaRepository;

    public ResponseCinemaDto createCinema(CreateCinemaDto createCinemaDto) {
        CinemaEntity cinemaEntity = new CinemaEntity();
        cinemaEntity.setName(createCinemaDto.getName());
        cinemaEntity.setAddress(createCinemaDto.getAddress());
        cinemaEntity.setManager(createCinemaDto.getManager());
        cinemaEntity.setMaxHalls(createCinemaDto.getMaxHalls());

        cinemaRepository.save(cinemaEntity);
        return new ResponseCinemaDto(
                cinemaEntity.getCinemaId(),
                cinemaEntity.getName(),
                cinemaEntity.getAddress(),
                cinemaEntity.getManager(),
                cinemaEntity.getMaxHalls(),
                cinemaEntity.getHallEntityList());
    }
}
