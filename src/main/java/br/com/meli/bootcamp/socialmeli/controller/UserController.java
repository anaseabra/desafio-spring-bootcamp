package br.com.meli.bootcamp.socialmeli.controller;

import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;
import br.com.meli.bootcamp.socialmeli.model.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public GlobalUserDto followSeller(@PathVariable int userId, @PathVariable int userIdToFollow) throws IOException {
        return userService.followSeller(userId, userIdToFollow);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<GlobalUserDto> getUserById(@PathVariable int userId) throws IOException {
            return ResponseEntity.status(200).body(this.userService.findById(userId));
    }


}
