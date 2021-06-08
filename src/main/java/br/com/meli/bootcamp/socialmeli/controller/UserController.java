package br.com.meli.bootcamp.socialmeli.controller;

import br.com.meli.bootcamp.socialmeli.exception.AlreadyFollowException;
import br.com.meli.bootcamp.socialmeli.exception.UserIsNotSellerException;
import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.model.dto.*;
import br.com.meli.bootcamp.socialmeli.model.service.GlobalUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private final GlobalUserService globalUserService;

    public UserController(GlobalUserService globalUserService) {
        this.globalUserService = globalUserService;
    }

    @PostMapping("/new")
    public ResponseEntity<GlobalUserDto> createNewUser(@RequestBody NewUser user) throws IOException {
        return ResponseEntity.status(200).body(this.globalUserService.createNewUser(user));
    }

    @GetMapping("/all")
    public ResponseEntity<List<GlobalUserDto>> getAllUsers() throws IOException {
        return ResponseEntity.status(200).body(this.globalUserService.getAllUsers());
    }

    @DeleteMapping("/{userId}/delete")
    public void deleteUser(@PathVariable int userId) throws NotFoundException, IOException {
        this.globalUserService.deleteUser(userId);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<GlobalUserDto> getUserById(@PathVariable int userId) throws NotFoundException, IOException {
        return ResponseEntity.status(200).body(this.globalUserService.getGlobalUserById(userId));
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<GlobalUserDto> followSeller(@PathVariable int userId, @PathVariable int userIdToFollow) throws NotFoundException, IOException, AlreadyFollowException, UserIsNotSellerException {
        return ResponseEntity.status(200).body(globalUserService.followSeller(userId, userIdToFollow));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDto> getTotalFollowers(@PathVariable int userId, @RequestParam(required = false) String orderBy) throws NotFoundException, IOException, UserIsNotSellerException {
        return ResponseEntity.status(200).body(globalUserService.getTotalFollowers(userId));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersDto> getFollowersList(@PathVariable int userId, @RequestParam(required = false) String orderBy) throws NotFoundException, IOException, UserIsNotSellerException {
        return ResponseEntity.status(200).body(globalUserService.getFollowersList(userId, orderBy));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedDto> getFollowedList(@PathVariable int userId, @RequestParam(required = false) String orderBy) throws NotFoundException, IOException {
        return ResponseEntity.status(200).body(globalUserService.getFollowedList(userId, orderBy));
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<GlobalUserDto> unfollowSeller(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws NotFoundException, IOException, AlreadyFollowException, UserIsNotSellerException {
        return ResponseEntity.status(200).body(globalUserService.unfollowSeller(userId, userIdToUnfollow));
    }
}