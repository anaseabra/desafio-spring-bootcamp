package br.com.meli.bootcamp.socialmeli.controller;

import br.com.meli.bootcamp.socialmeli.exception.UserIsNotSellerException;
import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.model.dto.FollowedDto;
import br.com.meli.bootcamp.socialmeli.model.dto.FollowersCountDto;
import br.com.meli.bootcamp.socialmeli.model.dto.FollowersDto;
import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;
import br.com.meli.bootcamp.socialmeli.model.service.GlobalUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/users/{userId}")
public class UserController {

    private final GlobalUserService globalUserService;

    public UserController(GlobalUserService globalUserService) {
        this.globalUserService = globalUserService;
    }

    @GetMapping("/")
    public ResponseEntity<GlobalUserDto> getUserById(@PathVariable int userId) throws Exception {
        return ResponseEntity.status(200).body(this.globalUserService.getGlobalUserById(userId));
    }

    @PostMapping("/follow/{userIdToFollow}")
    public ResponseEntity<GlobalUserDto> followSeller(@PathVariable int userId, @PathVariable int userIdToFollow) throws Exception {
        return ResponseEntity.status(200).body(globalUserService.followSeller(userId, userIdToFollow));
    }

    @GetMapping("/followers/count")
    public ResponseEntity<FollowersCountDto> getTotalFollowers(@PathVariable int userId, @RequestParam String orderBy) throws NotFoundException, IOException, UserIsNotSellerException {

        return ResponseEntity.status(200).body(globalUserService.getTotalFollowers(userId));
    }

    @GetMapping("/followers/list")
    public ResponseEntity<FollowersDto> getFollowersList(@PathVariable int userId, @RequestParam(required = false) String orderBy) throws NotFoundException, IOException, UserIsNotSellerException {
        return ResponseEntity.status(200).body(globalUserService.getFollowersList(userId, orderBy));
    }

    @GetMapping("/followed/list")
    public ResponseEntity<FollowedDto> getFollowedList(@PathVariable int userId, @RequestParam(required = false) String orderBy) throws Exception {
        return ResponseEntity.status(200).body(globalUserService.getFollowedList(userId, orderBy));
    }

    @PostMapping("/unfollow/{userIdToUnfollow}")
    public ResponseEntity<GlobalUserDto> unfollowSeller(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws Exception {
        return ResponseEntity.status(200).body(globalUserService.unfollowSeller(userId, userIdToUnfollow));
    }
}