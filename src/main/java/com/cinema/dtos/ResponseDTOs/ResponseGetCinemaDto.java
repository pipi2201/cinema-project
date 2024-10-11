package com.cinema.dtos.ResponseDTOs;

import com.cinema.dtos.HallDtoForList;
import com.cinema.dtos.RequestDTOs.CreateHallDto;
import com.cinema.entities.HallEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGetCinemaDto {
    private int cinemaId;
    private String name;
    private String address;
    private String manager;
    private int maxHalls;
    private List<HallDtoForList> halls;
}
