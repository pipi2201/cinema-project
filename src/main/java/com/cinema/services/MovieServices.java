package com.cinema.services;


import com.cinema.customExceptions.EmptyOptionalException;
import com.cinema.customExceptions.UnsupportedVersionException;
import com.cinema.dtos.RequestDTOs.CreateMovieDto;
import com.cinema.dtos.ResponseDTOs.ResponseCreateMovieDto;
import com.cinema.dtos.ResponseDTOs.ResponseGetMovieDto;
import com.cinema.entities.MovieEntity;
import com.cinema.entities.ScreenedMovieEntity;
import com.cinema.enums.MovieVersion;
import com.cinema.repositories.HallRepository;
import com.cinema.repositories.MovieRepository;
import com.cinema.repositories.ScreenedMovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieServices {
    private final MovieRepository movieRepository;
    private final ScreenedMovieRepository screenedMovieRepository;
    private final HallRepository hallRepository;

    public ResponseCreateMovieDto createMovie(CreateMovieDto createMovieDto) {
        MovieEntity movieEntity = new MovieEntity();

        movieEntity.setTitle(createMovieDto.getTitle());
        movieEntity.setMainCharacter(createMovieDto.getMainCharacter());
        movieEntity.setDescription(createMovieDto.getDescription());
        movieEntity.setMovieVersion(createMovieDto.getMovieVersion());
        movieEntity.setPremieredAt(createMovieDto.getPremieredAt());

        ScreenedMovieEntity screenedMovieEntity = new ScreenedMovieEntity();
        screenedMovieEntity.setMovie(movieEntity);
        if (hallRepository.findById(createMovieDto.getHallId()).isEmpty()) {
            throw new EmptyOptionalException("Hall not found");
        }
        screenedMovieEntity.setHall(hallRepository.findById(createMovieDto.getHallId()).get());
        screenedMovieEntity.setScreenTime(LocalDateTime.now());

        if (screenedMovieEntity.getMovie().getMovieVersion() != screenedMovieEntity.getHall().getSupportedMovieVersion()) {
            throw new UnsupportedVersionException("Movie version not supported");
        }
        movieRepository.save(movieEntity);
        screenedMovieRepository.save(screenedMovieEntity);
        return new ResponseCreateMovieDto(
                movieEntity.getMovieId(),
                movieEntity.getTitle(),
                movieEntity.getMainCharacter(),
                movieEntity.getDescription(),
                movieEntity.getPremieredAt(),
                movieEntity.getMovieVersion(),
                screenedMovieEntity.getHall().getHallId()
        );
    }

    public List<ResponseGetMovieDto> getMovies() {
        List<MovieEntity> movieEntities = movieRepository.findAll();
        return writeToDtos(movieEntities);
    }

    public List<ResponseGetMovieDto> getMovie(MovieVersion movieVersion) {
        if (movieRepository.findAllByMovieVersion(movieVersion).isEmpty()) {
            throw new EmptyOptionalException("Movies not found");
        }
        List<MovieEntity> movieEntityList = movieRepository.findAllByMovieVersion(movieVersion).get();
        return writeToDtos(movieEntityList);
    }

    public ResponseGetMovieDto updateMovie(int movieId, CreateMovieDto createMovieDto) {
        if (movieRepository.findById(movieId).isEmpty()) {
            throw new EmptyOptionalException("Movie not found");
        }
        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        movieEntity.setTitle(createMovieDto.getTitle());
        movieEntity.setMainCharacter(createMovieDto.getMainCharacter());
        movieEntity.setDescription(createMovieDto.getDescription());
        movieEntity.setMovieVersion(createMovieDto.getMovieVersion());
        movieEntity.setPremieredAt(createMovieDto.getPremieredAt());

        ScreenedMovieEntity screenedMovieEntity = new ScreenedMovieEntity();
        screenedMovieEntity.setMovie(movieEntity);
        if (hallRepository.findById(createMovieDto.getHallId()).isEmpty()) {
            throw new EmptyOptionalException("Hall not found");
        }
        screenedMovieEntity.setHall(hallRepository.findById(createMovieDto.getHallId()).get());
        screenedMovieEntity.setScreenTime(LocalDateTime.now());

        if (screenedMovieEntity.getMovie().getMovieVersion() != screenedMovieEntity.getHall().getSupportedMovieVersion()) {
            throw new UnsupportedVersionException("Movie version not supported");
        }
        movieRepository.save(movieEntity);
        screenedMovieRepository.save(screenedMovieEntity);
        return new ResponseGetMovieDto(
                movieEntity.getMovieId(),
                movieEntity.getTitle(),
                movieEntity.getMainCharacter(),
                movieEntity.getDescription(),
                movieEntity.getPremieredAt(),
                movieEntity.getMovieVersion()
        );
    }

    private List<ResponseGetMovieDto> writeToDtos(List<MovieEntity> movieEntities) {
        List<ResponseGetMovieDto> movieDtos = new ArrayList<>();
        for (MovieEntity movieEntity : movieEntities) {
            ResponseGetMovieDto movieDto = new ResponseGetMovieDto();
            movieDto.setMovieId(movieEntity.getMovieId());
            movieDto.setTitle(movieEntity.getTitle());
            movieDto.setMainCharacter(movieEntity.getMainCharacter());
            movieDto.setDescription(movieEntity.getDescription());
            movieDto.setPremieredAt(movieEntity.getPremieredAt());
            movieDto.setMovieVersion(movieEntity.getMovieVersion());
            movieDtos.add(movieDto);
        }
        return movieDtos;
    }
}
