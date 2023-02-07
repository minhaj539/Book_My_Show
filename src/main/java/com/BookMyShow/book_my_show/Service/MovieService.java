package com.BookMyShow.book_my_show.Service;

import com.BookMyShow.book_my_show.Models.MovieEntity;
import com.BookMyShow.book_my_show.Repository.MovieRepository;
import com.BookMyShow.book_my_show.RequestDto.MovieRequestDto;
import com.BookMyShow.book_my_show.ResponseDto.MovieResponseDto;
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
    public MovieResponseDto getMovieByName(String name) throws Exception{
        if(movieRepository.findByMovieName(name)==null) throw new Exception("movie does not exist");

        MovieEntity movie=movieRepository.findByMovieName(name);
        MovieResponseDto movieDto=new MovieResponseDto();
        movieDto.setName(movie.getMovieName());
        movieDto.setDuration(movie.getDuration());
        movieDto.setReleaseDate(movie.getReleaseDate());
        return movieDto;
    }
    public String deleteMovie(int movieId) throws Exception{
        if(movieRepository.findById(movieId)==null) throw new Exception("movie does not exist");

         movieRepository.deleteById(movieId);
         return "movie deleted successfully";
    }

}
