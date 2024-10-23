package com.cinema.services;

import com.cinema.customExceptions.EmptyOptionalException;
import com.cinema.customExceptions.HasMovieScreeningException;
import com.cinema.customExceptions.MaxCapacityException;
import com.cinema.customExceptions.MovieVersionUpdateException;
import com.cinema.dtos.RequestDTOs.CreateHallDto;
import com.cinema.dtos.RequestDTOs.UpdateHallDto;
import com.cinema.dtos.ResponseDTOs.ResponseHallDto;
import com.cinema.entities.HallEntity;
import com.cinema.enums.MovieVersion;
import com.cinema.repositories.HallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

        if (hallEntity.getCinema().getHallEntityList().size() >= hallEntity.getCinema().getMaxHalls()) {
            throw new MaxCapacityException("Maximum hall capacity met");
        }
        hallRepository.save(hallEntity);

        return new ResponseHallDto(
                hallEntity.getHallId(),
                hallEntity.getCapacity(),
                hallEntity.getOccupiedSeats(),
                hallEntity.getSupportedMovieVersion(),
                hallEntity.getCinema().getCinemaId()
        );
    }

    public ResponseHallDto getHall(int hallId) {
        Optional<HallEntity> hallEntityOptional = hallRepository.findById(hallId);
        if (hallEntityOptional.isEmpty()) {
            throw new EmptyOptionalException("Hall not found");
        }
        HallEntity hallEntity = hallEntityOptional.get();
        return new ResponseHallDto(hallEntity.getHallId(), hallEntity.getCapacity(), hallEntity.getOccupiedSeats(), hallEntity.getSupportedMovieVersion(), hallEntity.getCinema().getCinemaId());
    }

    public ResponseHallDto updateHall(int hallId, UpdateHallDto updateHallDto) {
        Optional<HallEntity> hallEntityOptional = hallRepository.findById(hallId);
        if (hallEntityOptional.isEmpty()) {
            throw new EmptyOptionalException("Hall not found");
        }
        HallEntity hallEntity = hallEntityOptional.get();
        hallEntity.setCapacity(updateHallDto.getCapacity());
        hallEntity.setOccupiedSeats(updateHallDto.getOccupiedSeats());
        if (!hallEntity.getSupportedMovieVersion().equals(updateHallDto.getSupportedMovieVersion())) {
            if (hallEntity.getSupportedMovieVersion() == MovieVersion.DBOX && updateHallDto.getSupportedMovieVersion() == MovieVersion.R3D) {
                hallEntity.setSupportedMovieVersion(updateHallDto.getSupportedMovieVersion());
            }
            else throw new MovieVersionUpdateException("Update possible only from 5D to 3D");
        }
        if (!hallEntity.getScreenedMovieEntityList().isEmpty()) {
            throw new HasMovieScreeningException("Movie screening in this hall");
        }

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
