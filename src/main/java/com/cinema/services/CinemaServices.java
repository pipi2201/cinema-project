package com.cinema.services;

import com.cinema.dtos.RequestDTOs.CreateCinemaDto;
import com.cinema.dtos.ResponseDTOs.ResponseCreateCinemaDto;
import com.cinema.dtos.ResponseDTOs.ResponseGetCinemaDto;
import com.cinema.entities.CinemaEntity;
import com.cinema.repositories.CinemaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CinemaServices {

    public CinemaRepository cinemaRepository;

    public ResponseCreateCinemaDto createCinema(CreateCinemaDto createCinemaDto) {
        CinemaEntity cinemaEntity = new CinemaEntity();
        cinemaEntity.setName(createCinemaDto.getName());
        cinemaEntity.setAddress(createCinemaDto.getAddress());
        cinemaEntity.setManager(createCinemaDto.getManager());
        cinemaEntity.setMaxHalls(createCinemaDto.getMaxHalls());

        cinemaRepository.save(cinemaEntity);
        return new ResponseCreateCinemaDto(
                cinemaEntity.getCinemaId(),
                cinemaEntity.getName(),
                cinemaEntity.getAddress(),
                cinemaEntity.getManager(),
                cinemaEntity.getMaxHalls());
    }


    public CinemaEntity getCinemaById(int cinemaId) {
        Optional<CinemaEntity> cinemaEntityOptional = cinemaRepository.findById(cinemaId);
        if (cinemaEntityOptional.isEmpty()) {
            throw new RuntimeException("Cinema not found");
        }
        return cinemaEntityOptional.get();
    }

    public List<ResponseGetCinemaDto> getAllCinemas() {
        List<CinemaEntity> cinemaEntityList = cinemaRepository.findAll();
        List<ResponseGetCinemaDto> cinemaDtoList = new ArrayList<>();
        for (CinemaEntity cinemaEntity : cinemaEntityList) {
            ResponseGetCinemaDto cinemaDto = new ResponseGetCinemaDto();
            cinemaDto.setCinemaId(cinemaEntity.getCinemaId());
            cinemaDto.setName(cinemaEntity.getName());
            cinemaDto.setAddress(cinemaEntity.getAddress());
            cinemaDto.setManager(cinemaEntity.getManager());
            cinemaDto.setMaxHalls(cinemaEntity.getMaxHalls());
            cinemaDto.setHallEntityList(cinemaEntity.getHallEntityList());

            cinemaDtoList.add(cinemaDto);
        }
        return cinemaDtoList;
    }
}
