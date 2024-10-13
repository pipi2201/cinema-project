package com.cinema.services;


import com.cinema.dtos.RequestDTOs.CreateMovieDto;
import com.cinema.dtos.ResponseDTOs.ResponseCreateMovieDto;
import com.cinema.entities.MovieEntity;
import com.cinema.entities.ScreenedMovieEntity;
import com.cinema.repositories.HallRepository;
import com.cinema.repositories.MovieRepository;
import com.cinema.repositories.ScreenedMovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

        movieRepository.save(movieEntity);

        ScreenedMovieEntity screenedMovieEntity = new ScreenedMovieEntity();
        screenedMovieEntity.setMovie(movieEntity);
        screenedMovieEntity.setHall(hallRepository.findById(createMovieDto.getHallId()).get());
        screenedMovieEntity.setScreenTime(LocalDateTime.now());

        if(screenedMovieEntity.getMovie().getMovieVersion().equals(screenedMovieEntity.getHall().getSupportedMovieVersion())) {
            System.out.println("movieversion matches");
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
        System.out.println("movieversion doesn't match");
        return null;
    }
}
