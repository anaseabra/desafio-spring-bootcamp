package br.com.meli.bootcamp.socialmeli.model.service;

import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.exception.PromoPostException;
import br.com.meli.bootcamp.socialmeli.exception.UserIsNotSellerException;
import br.com.meli.bootcamp.socialmeli.model.dto.FollowedPostsDto;
import br.com.meli.bootcamp.socialmeli.model.dto.PostDto;
import br.com.meli.bootcamp.socialmeli.model.dto.PromoPostCountDto;
import br.com.meli.bootcamp.socialmeli.model.dto.PromoPostListDto;

import java.io.IOException;

public interface PostService {

    PostDto createNewPost (PostDto postDto) throws IOException, NotFoundException, UserIsNotSellerException, PromoPostException;
    FollowedPostsDto getFollowedPosts(int userId, String orderBy) throws Exception;
    PostDto createNewPromoPost(PostDto promoPost) throws PromoPostException, IOException, NotFoundException, UserIsNotSellerException;
    PromoPostCountDto getTotalPromoPosts (int userId) throws Exception;
    PromoPostListDto getPromoPosts (int userId) throws Exception;
}
