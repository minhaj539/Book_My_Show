package com.BookMyShow.book_my_show.Controller;
import com.BookMyShow.book_my_show.RequestDto.TicketRequestDto;
import com.BookMyShow.book_my_show.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
       // throw new RuntimeException(e);
        return e.getMessage();
    }
}
@DeleteMapping("cancel")
    public String cancelTicket(@RequestParam("id") int ticketId){
    try {
        return ticketService.cancelTicket(ticketId);
    }
    catch(Exception e){
        return e.getMessage();
    }
}
}
