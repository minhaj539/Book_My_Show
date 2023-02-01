package com.BookMyShow.book_my_show.Repository;


import com.BookMyShow.book_my_show.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
