package com.BookMyShow.book_my_show.RequestDto;
import lombok.Data;

import java.util.List;

@Data
public class TicketRequestDto {
    private int showId;
    private int userId;
    private List<String> requestedSeats;
}
