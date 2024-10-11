package com.cinema.repositories;

import com.cinema.entities.HallEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<HallEntity, Integer> {
}
