package com.BookMyShow.book_my_show.Service;

import com.BookMyShow.book_my_show.Models.UserEntity;
import com.BookMyShow.book_my_show.Repository.UserRepository;
import com.BookMyShow.book_my_show.RequestDto.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public String addUser(UserRequestDto userRequestDto){
        UserEntity user=new UserEntity();
        user.setName(userRequestDto.getName());
        user.setMobile(userRequestDto.getMobile());
        user.setCreatedOn(new Date());
        userRepository.save(user);
        return "user added successfully";
    }
}
