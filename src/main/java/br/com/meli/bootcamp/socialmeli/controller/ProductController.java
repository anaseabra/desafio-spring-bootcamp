package br.com.meli.bootcamp.socialmeli.controller;

import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.exception.PromoPostException;
import br.com.meli.bootcamp.socialmeli.exception.UserIsNotSellerException;
import br.com.meli.bootcamp.socialmeli.model.dto.FollowedPostsDto;
import br.com.meli.bootcamp.socialmeli.model.dto.PostDto;
import br.com.meli.bootcamp.socialmeli.model.dto.PromoPostCountDto;
import br.com.meli.bootcamp.socialmeli.model.dto.PromoPostListDto;
import br.com.meli.bootcamp.socialmeli.model.service.PostService;
import br.com.meli.bootcamp.socialmeli.model.service.GlobalUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final PostService postService;
    private final GlobalUserService globalUserService;

    public ProductController(final PostService postService, final GlobalUserService globalUserService) {
        this.postService = postService;
        this.globalUserService = globalUserService;
    }

    @PostMapping("/newpost")
    public ResponseEntity<PostDto> newPost(@RequestBody PostDto postDto) throws Exception {
        return ResponseEntity.status(201).body(postService.createNewPost(postDto));
    }

    @GetMapping("followed/{userId}/list")
    public ResponseEntity<FollowedPostsDto> getFollowedPosts(@PathVariable int userId, @RequestParam(required = false) String orderBy) throws Exception {
        return ResponseEntity.status(200).body(postService.getFollowedPosts(userId, orderBy));
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<PostDto> newPromoPost(@RequestBody PostDto postDto) throws NotFoundException, IOException, UserIsNotSellerException, PromoPostException {
        return ResponseEntity.status(201).body(postService.createNewPromoPost(postDto));
    }

    @GetMapping("/{userId}/countpromo")
    public ResponseEntity<PromoPostCountDto> getTotalPromoPosts(@PathVariable int userId) throws Exception {
        return ResponseEntity.status(200).body(postService.getTotalPromoPosts(userId));
    }

    @GetMapping("{userId}/list")
    public ResponseEntity<PromoPostListDto> getPromoPosts(@PathVariable int userId) throws Exception {
        return ResponseEntity.status(200).body(postService.getPromoPosts(userId));
    }

}
