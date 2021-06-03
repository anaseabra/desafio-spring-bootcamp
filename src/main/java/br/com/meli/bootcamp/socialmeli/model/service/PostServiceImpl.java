package br.com.meli.bootcamp.socialmeli.model.service;

import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.exception.UserIsNotSellerException;
import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;
import br.com.meli.bootcamp.socialmeli.model.dto.PostDto;
import br.com.meli.bootcamp.socialmeli.model.repository.GlobalUserRepository;
import br.com.meli.bootcamp.socialmeli.model.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final GlobalUserService globalUserService;

    public PostServiceImpl(final PostRepository postRepository, final GlobalUserService globalUserService) {
        this.postRepository = postRepository;
        this.globalUserService = globalUserService;
    }

    @Override
    public PostDto createNewPost(PostDto postDto) throws IOException, NotFoundException, UserIsNotSellerException {
        PostDto newPost = postRepository.createNewPost(postDto);
        globalUserService.addPostIdToSellerUser(postDto);
        return newPost;
    }
}
