package com.BookMyShow.book_my_show.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDto{
    private String name;
    private int duration;

    private Date releaseDate;
}
