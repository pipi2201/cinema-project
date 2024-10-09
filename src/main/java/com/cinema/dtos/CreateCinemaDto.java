package com.cinema.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateCinemaDto {
    private String name;
    private String address;
    private String manager;
    private int maxHalls;
}
