package com.BookMyShow.book_my_show.Controller;
import com.BookMyShow.book_my_show.RequestDto.TicketRequestDto;
import com.BookMyShow.book_my_show.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
@Autowired
    TicketService ticketService;

@PostMapping("book")
public String bookTicket(@RequestBody TicketRequestDto ticketRequestDto) {

    try {
        return ticketService.bookTicket(ticketRequestDto);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
}
