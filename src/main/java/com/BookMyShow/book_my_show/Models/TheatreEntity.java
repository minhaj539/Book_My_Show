package com.BookMyShow.book_my_show.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="theatre")
@Data
@NoArgsConstructor
public class TheatreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String address;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    List<TheatreSeatEntity> theatreSeatEntityList;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    List<ShowEntity> listOfShows;

}
