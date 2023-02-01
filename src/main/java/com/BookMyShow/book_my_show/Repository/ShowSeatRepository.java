package com.BookMyShow.book_my_show.Repository;

import com.BookMyShow.book_my_show.Models.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeatEntity,Integer> {
    public ShowSeatEntity findBySeatNo(String seatNo);
}
