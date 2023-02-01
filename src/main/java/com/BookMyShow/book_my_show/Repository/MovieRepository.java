package com.BookMyShow.book_my_show.Repository;


import com.BookMyShow.book_my_show.Models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {

    public MovieEntity findByMovieName(String movieName);
}
