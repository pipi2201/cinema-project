package com.cinema.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CinemaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cinemaId;
    private String name;
    private String address;
    private String manager;
    private int maxHalls;

    @OneToMany (mappedBy = "cinema", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<HallEntity> hallEntityList;
}
