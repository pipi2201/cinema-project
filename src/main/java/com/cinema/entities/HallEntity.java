package com.cinema.entities;

import com.cinema.enums.MovieVersion;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class HallEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hallId;
    private int capacity;
    private int occupiedSeats;
    @Enumerated(EnumType.STRING)
    private MovieVersion supportedMovieVersion;

    @ManyToOne
    @JoinColumn(name = "cinemaId")
    private CinemaEntity cinema;

    @OneToMany(mappedBy = "hall")
    private List<ScreenedMovieEntity> screenedMovieEntityList;
}
