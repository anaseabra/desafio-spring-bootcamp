package br.com.meli.bootcamp.socialmeli.controller;

import br.com.meli.bootcamp.socialmeli.model.dto.FollowersCountDto;
import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;
import br.com.meli.bootcamp.socialmeli.model.dto.UserDetail;
import br.com.meli.bootcamp.socialmeli.model.service.UserService;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.status(200).body(this.userService.findById(userId));
    }

    @PostMapping("/follow/{userIdToFollow}")
    public ResponseEntity<GlobalUserDto> followSeller(@PathVariable int userId, @PathVariable int userIdToFollow) throws Exception {
        return ResponseEntity.status(200).body(userService.followSeller(userId, userIdToFollow));
    }

    @GetMapping("/followers/count")
    public ResponseEntity<FollowersCountDto> getFollowersCount(@PathVariable int userId) throws Exception {
        GlobalUserDto seller = userService.findById(userId);
        if(!seller.isSeller()){
            throw new Exception("User is not a seller");
        }

        FollowersCountDto followersCountDto = new FollowersCountDto();
        followersCountDto.setUserId(seller.getUserId());
        followersCountDto.setUserName(seller.getUserName());
        followersCountDto.setFollowersCount(seller.getFollowers().size());

        return ResponseEntity.status(200).body(followersCountDto);
    }
}
