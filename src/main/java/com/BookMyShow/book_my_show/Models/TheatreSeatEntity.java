package com.BookMyShow.book_my_show.Models;


import com.BookMyShow.book_my_show.Enums.Seat_Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="theatre_seats")
public class TheatreSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;
    @Enumerated(EnumType.STRING)
    private Seat_Type seatType;
    private int rate;

    @ManyToOne
    @JoinColumn
    private TheatreEntity theatre;

    public TheatreSeatEntity(String seatNo,Seat_Type seatType, int rate) {
        this.seatNo=seatNo;
        this.seatType=seatType;
        this.rate=rate;
    }
}
