package br.com.meli.bootcamp.socialmeli.model.repository;

import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.model.dto.PostDto;

import java.io.IOException;
import java.util.List;

public interface PostRepository {

    PostDto getPostById(int postId) throws NotFoundException, IOException;
    PostDto createNewPost(PostDto postDto) throws IOException;

}
