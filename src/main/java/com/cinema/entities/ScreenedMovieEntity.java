package com.cinema.entities;

import com.cinema.entities.pk.ScreenedMoviePk;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ScreenedMoviePk.class)
public class ScreenedMovieEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "hallId")
    private HallEntity hall;
    @Id
    @ManyToOne
    @JoinColumn(name = "movieId")
    private MovieEntity movie;
    @Id
    private LocalDateTime screenTime;
}
