package com.BookMyShow.book_my_show.Models;


import com.BookMyShow.book_my_show.Enums.Seat_Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "show_seats")
public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;
    private Date booked_at;

    @Enumerated(EnumType.STRING)
    private Seat_Type seatType;
    private boolean booked;

    @ManyToOne
    @JoinColumn
    private ShowEntity show;


    @ManyToOne
    @JoinColumn
    private TicketEntity ticket;

}
