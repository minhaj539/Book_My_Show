package com.BookMyShow.book_my_show.Controller;
import com.BookMyShow.book_my_show.Repository.UserRepository;
import com.BookMyShow.book_my_show.RequestDto.UserRequestDto;
import com.BookMyShow.book_my_show.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody UserRequestDto userRequestDto){
        return userService.addUser(userRequestDto);
    }
}
