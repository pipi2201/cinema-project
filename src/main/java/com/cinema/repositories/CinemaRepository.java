package com.cinema.repositories;

import com.cinema.entities.CinemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CinemaRepository extends JpaRepository<CinemaEntity, Integer> {
}
