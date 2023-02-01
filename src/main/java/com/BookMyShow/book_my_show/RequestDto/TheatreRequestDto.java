package com.BookMyShow.book_my_show.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheatreRequestDto {
    private  String name;
    private String address;
    private String city;

}
