package com.BookMyShow.book_my_show.Service;

import com.BookMyShow.book_my_show.Enums.Seat_Type;
import com.BookMyShow.book_my_show.Models.TheatreEntity;
import com.BookMyShow.book_my_show.Models.TheatreSeatEntity;
import com.BookMyShow.book_my_show.Repository.TheatreRepository;
import com.BookMyShow.book_my_show.Repository.TheatreSeatRepository;
import com.BookMyShow.book_my_show.RequestDto.TheatreRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatRepository theatreSeatRepository;

    public String addTheatre(TheatreRequestDto theatreRequestDto){
        TheatreEntity theatre=new TheatreEntity();
        theatre.setName(theatreRequestDto.getName());
        theatre.setAddress(theatreRequestDto.getAddress());
        theatre.setCity(theatreRequestDto.getCity());
        List<TheatreSeatEntity> createTheatreSeats=createTheatreSeats();
        theatre.setTheatreSeatEntityList(createTheatreSeats);
        for(TheatreSeatEntity seat: createTheatreSeats){
            seat.setTheatre(theatre);
        }
        theatreRepository.save(theatre);
        return "theatre add successfully";
    }

    public List<TheatreSeatEntity> createTheatreSeats(){
        List<TheatreSeatEntity> createSeats=new ArrayList<>();
        int i=1;
        for(;i<=10;i++){
            TheatreSeatEntity seat=new TheatreSeatEntity();
            String s="A"+i;
            seat.setSeatNo(s);
            seat.setSeatType(Seat_Type.CLASSIC);
            seat.setRate(100);
            createSeats.add(seat);
        }
        //theatreSeatRepository.saveAll(createSeats);
        return createSeats;
    }
}
