package com.cinema.dtos.ResponseDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ResponseCreateCinemaDto {
    private int cinemaId;
    private String name;
    private String address;
    private String manager;
    private int maxHalls;

}
