package br.com.meli.bootcamp.socialmeli.model.service;

import br.com.meli.bootcamp.socialmeli.exception.UserIsNotSellerException;
import br.com.meli.bootcamp.socialmeli.exception.UserNotFoundException;
import br.com.meli.bootcamp.socialmeli.model.dto.FollowersCountDto;
import br.com.meli.bootcamp.socialmeli.model.dto.FollowersDto;
import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;

import java.io.IOException;


public interface UserService {

    GlobalUserDto getGlobalUserById(int userId) throws Exception;
    GlobalUserDto getSellerUserById(int sellerId) throws Exception;
    GlobalUserDto followSeller(int userId, int sellerId) throws Exception;
    FollowersDto getFollowers(int userId) throws UserNotFoundException, IOException, UserIsNotSellerException;
    FollowersCountDto getTotalFollowers (int userId) throws UserNotFoundException, IOException, UserIsNotSellerException;

}
