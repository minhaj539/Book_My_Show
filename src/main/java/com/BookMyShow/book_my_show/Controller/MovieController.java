package com.BookMyShow.book_my_show.Controller;


import com.BookMyShow.book_my_show.Models.MovieEntity;
import com.BookMyShow.book_my_show.RequestDto.MovieRequestDto;
import com.BookMyShow.book_my_show.ResponseDto.MovieResponseDto;
import com.BookMyShow.book_my_show.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public String addMovie(@RequestBody MovieRequestDto movieRequestDto){

        return movieService.addMovie(movieRequestDto);
    }
    @GetMapping("/get_movie_by_name")
    public ResponseEntity getMovieByName(@RequestParam("name") String name){
        MovieResponseDto movie;
        try{
            movie=movieService.getMovieByName(name);
        }
        catch (Exception e){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(movie,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("delete")
    public String deleteMovie(@RequestParam("id") int movieId){
        String res;
        try{
            res=movieService.deleteMovie(movieId);
        }
        catch (Exception e){
            return e.getMessage();
        }
        return res;
    }


    //Get movie by Name
}