package br.com.meli.bootcamp.socialmeli.model.service;

import br.com.meli.bootcamp.socialmeli.exception.UserIsNotSellerException;
import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.model.dto.*;

import java.io.IOException;


public interface GlobalUserService {

    GlobalUserDto getGlobalUserById(int userId) throws Exception;
    GlobalUserDto getSellerUserById(int sellerId) throws Exception;
    GlobalUserDto followSeller(int userId, int sellerId) throws Exception;
    FollowersCountDto getTotalFollowers (int userId) throws NotFoundException, IOException, UserIsNotSellerException;
    FollowersDto getFollowersList(int userId, String orderBy) throws NotFoundException, IOException, UserIsNotSellerException;
    FollowedDto getFollowedList (int userId, String orderBy) throws NotFoundException, IOException;
    GlobalUserDto unfollowSeller(int userId, int sellerId) throws Exception;
    void addPostIdToSellerUser(PostDto postDto) throws NotFoundException, IOException, UserIsNotSellerException;

}
