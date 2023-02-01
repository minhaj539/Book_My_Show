package com.BookMyShow.book_my_show.Repository;

import com.BookMyShow.book_my_show.Models.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreSeatRepository extends JpaRepository<TheatreSeatEntity,Integer> {
}
