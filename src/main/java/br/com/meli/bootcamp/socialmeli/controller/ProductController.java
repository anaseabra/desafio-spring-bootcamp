package br.com.meli.bootcamp.socialmeli.controller;

import br.com.meli.bootcamp.socialmeli.model.dto.FollowedPostsDto;
import br.com.meli.bootcamp.socialmeli.model.dto.PostDto;
import br.com.meli.bootcamp.socialmeli.model.service.PostService;
import br.com.meli.bootcamp.socialmeli.model.service.GlobalUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<FollowedPostsDto> getFollowedPosts(@PathVariable int userId){
        return null;
    }

}
