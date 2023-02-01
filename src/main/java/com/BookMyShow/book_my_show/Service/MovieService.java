package com.BookMyShow.book_my_show.Service;

import com.BookMyShow.book_my_show.Models.MovieEntity;
import com.BookMyShow.book_my_show.Repository.MovieRepository;
import com.BookMyShow.book_my_show.RequestDto.MovieRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieRequestDto movieRequestDto){

        //Convert Dto to Entity layer for saving it to the Database.
        MovieEntity movie = MovieEntity.builder().movieName(movieRequestDto.getName()).duration(movieRequestDto.getDuration()).releaseDate(movieRequestDto.getReleaseDate()).build();

        movieRepository.save(movie);

        return "Movie Added successfully";
    }


}
