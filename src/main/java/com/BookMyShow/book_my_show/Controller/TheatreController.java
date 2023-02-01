package com.BookMyShow.book_my_show.Controller;

import com.BookMyShow.book_my_show.RequestDto.TheatreRequestDto;
import com.BookMyShow.book_my_show.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;
 @PostMapping("add")
    public String addTheatre(@RequestBody TheatreRequestDto theatreRequestDto){
     return theatreService.addTheatre(theatreRequestDto);
 }
}
