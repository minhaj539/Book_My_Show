package com.BookMyShow.book_my_show.RequestDto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
@Data
public class ShowRequestDto {
    private int theatreId;
    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private double multiplier;

}
