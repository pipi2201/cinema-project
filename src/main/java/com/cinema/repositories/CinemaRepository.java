package com.cinema.repositories;

import com.cinema.entities.CinemaEntity;
import org.springframework.data.repository.CrudRepository;

public interface CinemaRepository extends CrudRepository<CinemaEntity, Integer> {
}
