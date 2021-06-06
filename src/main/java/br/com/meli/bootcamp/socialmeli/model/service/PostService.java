package br.com.meli.bootcamp.socialmeli.model.service;

import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.exception.UserIsNotSellerException;
import br.com.meli.bootcamp.socialmeli.model.dto.FollowedPostsDto;
import br.com.meli.bootcamp.socialmeli.model.dto.PostDto;

import java.io.IOException;

public interface PostService {

    PostDto createNewPost (PostDto postDto) throws IOException, NotFoundException, UserIsNotSellerException;
    FollowedPostsDto getFollowedPosts(int userId, String orderBy) throws Exception;
}
