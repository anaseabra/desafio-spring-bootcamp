package br.com.meli.bootcamp.socialmeli.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public void followSeller(@PathVariable int userId, @PathVariable int userIdToFollow){

    }


}
