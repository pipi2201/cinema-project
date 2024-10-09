package com.cinema.dtos;

import com.cinema.entities.HallEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ResponseCinemaDto {
    private int cinemaId;
    private String name;
    private String address;
    private String manager;
    private int maxHalls;
    private List<HallEntity> hallEntityList;
}
