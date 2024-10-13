package com.cinema.repositories;

import com.cinema.entities.MovieEntity;
import com.cinema.enums.MovieVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    Optional<List<MovieEntity>> findAllByMovieVersion(MovieVersion movieVersion);
}
