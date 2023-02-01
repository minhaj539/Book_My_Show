package com.BookMyShow.book_my_show.Repository;

import com.BookMyShow.book_my_show.Models.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<TheatreEntity,Integer> {
}
