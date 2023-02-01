package com.BookMyShow.book_my_show.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "movies")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true)
    private String movieName;

    private int duration;

    private Date releaseDate;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<ShowEntity> listOfShows;




}
