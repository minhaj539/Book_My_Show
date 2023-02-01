package com.BookMyShow.book_my_show.Service;

import com.BookMyShow.book_my_show.Models.*;
import com.BookMyShow.book_my_show.Repository.MovieRepository;
import com.BookMyShow.book_my_show.Repository.ShowRepository;
import com.BookMyShow.book_my_show.Repository.ShowSeatRepository;
import com.BookMyShow.book_my_show.Repository.TheatreRepository;
import com.BookMyShow.book_my_show.RequestDto.ShowRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ShowService {


    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;


    @Autowired
    ShowSeatRepository showSeatRepository;

    @Autowired
    ShowRepository showRepository;

    public String addShow(ShowRequestDto showRequestDto){


        //Show Entity
        ShowEntity showEntity = ShowEntity.builder().showDate(showRequestDto.getShowDate()).showTime(showRequestDto.getShowTime()).multiplier(showRequestDto.getMultiplier()).build();


        //You need to get the movieRepo
        MovieEntity movieEntity = movieRepository.findByMovieName(showRequestDto.getMovieName());

        //You need to get the theater Repository

        TheatreEntity theaterEntity = theatreRepository.findById(showRequestDto.getTheatreId()).get();

        showEntity.setTheatre(theaterEntity);
        showEntity.setMovie(movieEntity);

        //bcz we are doing a bidirectional mapping :
        //Optional things :
//        List<ShowEntity> currentListOfShow = movieEntity.getListOfShows();
//        currentListOfShow.add(showEntity);
//        movieEntity.setListOfShows(currentListOfShow);
        movieEntity.getListOfShows().add(showEntity);
        theaterEntity.getListOfShows().add(showEntity);
        //theaterRepository.save(theaterEntity);

        List<ShowSeatEntity> seatEntityList = createShowSeats(theaterEntity.getTheatreSeatEntityList());

        showEntity.setListOfSeats(seatEntityList);

        //For each ShowSeat : we need to mark that to which show it belongs (foriegn key will be filled )
        for(ShowSeatEntity showSeat:seatEntityList){
            showSeat.setShow(showEntity);
        }

        movieRepository.save(movieEntity);
        theatreRepository.save(theaterEntity);
        //showRepository.save(showEntity); this doessnt need to be called bcz parent save function is being called.

        return "Show added successfully";

    }

    public List<ShowSeatEntity> createShowSeats(List<TheatreSeatEntity> theaterSeatEntityList){


        List<ShowSeatEntity> seats = new ArrayList<>();

        for(TheatreSeatEntity theaterSeat: theaterSeatEntityList){

            ShowSeatEntity showSeat = ShowSeatEntity.builder().seatNo(theaterSeat.getSeatNo()).seatType(theaterSeat.getSeatType()).build();
            seats.add(showSeat);
        }

        showSeatRepository.saveAll(seats);

        return seats;
    }
}