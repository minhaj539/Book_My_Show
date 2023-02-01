package com.BookMyShow.book_my_show.Repository;

import com.BookMyShow.book_my_show.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
