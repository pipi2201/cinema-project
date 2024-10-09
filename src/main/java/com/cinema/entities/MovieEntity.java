package com.cinema.entities;

import com.cinema.enums.MovieVersion;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    private String title;
    private String mainCharacter;
    private String description;
    private LocalDate premieredAt;
    @Enumerated(EnumType.STRING)
    private MovieVersion movieVersion;

    @OneToMany(mappedBy = "movie")
    private List<ScreenedMovieEntity> screenedMovieEntityList;
}
