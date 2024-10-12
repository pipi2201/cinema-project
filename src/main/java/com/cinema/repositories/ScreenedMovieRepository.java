package com.cinema.repositories;

import com.cinema.entities.ScreenedMovieEntity;
import com.cinema.entities.pk.ScreenedMoviePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenedMovieRepository extends JpaRepository<ScreenedMovieEntity, ScreenedMoviePk> {
}
