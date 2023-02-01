package com.BookMyShow.book_my_show.Repository;

import com.BookMyShow.book_my_show.Models.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {
}
