package com.cinema.services;


import com.cinema.dtos.RequestDTOs.CreateMovieDto;
import com.cinema.dtos.ResponseDTOs.ResponseCreateMovieDto;
import com.cinema.dtos.ResponseDTOs.ResponseHallDto;
import com.cinema.entities.HallEntity;
import com.cinema.entities.MovieEntity;
import com.cinema.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieServices {
    MovieRepository movieRepository;

    public ResponseCreateMovieDto createMovie(CreateMovieDto createMovieDto) {
//        MovieEntity movieEntity = new MovieEntity();
//        movieEntity.setTitle(createMovieDto.getTitle());
//        movieEntity.setMainCharacter(createMovieDto.getMainCharacter());
//        movieEntity.setDescription(createMovieDto.getDescription());
//        movieEntity.setMovieVersion(createMovieDto.getMovieVersion());
//        movieEntity.setPremieredAt(createMovieDto.getPremieredAt());
//
//        movieRepository.save(movieEntity);
//
//        return new ResponseCreateMovieDto(
//            movieEntity.getMovieId(),
//                movieEntity.getTitle(),
//                movieEntity.getMainCharacter(),
//                movieEntity.getDescription(),
//                movieEntity.getPremieredAt(),
//                movieEntity.getMovieVersion());
        return null;
    }
}
