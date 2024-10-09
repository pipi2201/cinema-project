package com.cinema.services;

import com.cinema.dtos.RequestDTOs.CreateCinemaDto;
import com.cinema.dtos.ResponseDTOs.ResponseCinemaDto;
import com.cinema.entities.CinemaEntity;
import com.cinema.repositories.CinemaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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


    public CinemaEntity getCinemaById(int cinemaId) {
        Optional<CinemaEntity> cinemaEntityOptional = cinemaRepository.findById(cinemaId);
        if (cinemaEntityOptional.isEmpty()) {
            throw new RuntimeException("Cinema not found");
        }
        return cinemaEntityOptional.get();
    }
}
