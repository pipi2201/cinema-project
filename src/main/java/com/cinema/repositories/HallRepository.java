package com.cinema.repositories;

import com.cinema.entities.HallEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface HallRepository extends JpaRepository<HallEntity, Integer> {
}
