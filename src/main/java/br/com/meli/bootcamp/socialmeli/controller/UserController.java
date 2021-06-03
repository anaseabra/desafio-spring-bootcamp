package br.com.meli.bootcamp.socialmeli.controller;

import br.com.meli.bootcamp.socialmeli.exception.UserIsNotSellerException;
import br.com.meli.bootcamp.socialmeli.exception.UserNotFoundException;
import br.com.meli.bootcamp.socialmeli.model.dto.FollowersCountDto;
import br.com.meli.bootcamp.socialmeli.model.dto.FollowersDto;
import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;
import br.com.meli.bootcamp.socialmeli.model.dto.UserDetail;
import br.com.meli.bootcamp.socialmeli.model.service.UserService;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users/{userId}")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<GlobalUserDto> getUserById(@PathVariable int userId) throws Exception {
        return ResponseEntity.status(200).body(this.userService.getGlobalUserById(userId));
    }

    @PostMapping("/follow/{userIdToFollow}")
    public ResponseEntity<GlobalUserDto> followSeller(@PathVariable int userId, @PathVariable int userIdToFollow){
        return ResponseEntity.status(200).body(userService.followSeller(userId, userIdToFollow));
    }

    @GetMapping("/followers/count")
    public ResponseEntity<FollowersCountDto> getTotalFollowers(@PathVariable int userId) throws UserNotFoundException, IOException, UserIsNotSellerException {

        return ResponseEntity.status(200).body(userService.getTotalFollowers(userId));
    }

    @GetMapping("/followers/list")
    public ResponseEntity<FollowersDto> getFollowers(@PathVariable int userId) throws UserNotFoundException, IOException, UserIsNotSellerException {
        return ResponseEntity.status(200).body(userService.getFollowers(userId));
    }

    @GetMapping("/followed/list")
    public ResponseEntity<FollowersDto> getFollowedList(@PathVariable int userId) throws Exception {

    }
}
