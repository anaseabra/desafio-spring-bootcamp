package br.com.meli.bootcamp.socialmeli.model.service;

import br.com.meli.bootcamp.socialmeli.exception.AlreadyFollowException;
import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.exception.UserIsNotSellerException;
import br.com.meli.bootcamp.socialmeli.model.dto.*;

import java.io.IOException;
import java.util.List;


public interface GlobalUserService {

    GlobalUserDto createNewUser(NewUser user) throws IOException;
    void deleteUser(int userId) throws NotFoundException, IOException;
    List<GlobalUserDto> getAllUsers() throws IOException;
    GlobalUserDto getGlobalUserById(int userId) throws NotFoundException, IOException;
    GlobalUserDto getSellerUserById(int sellerId) throws NotFoundException, UserIsNotSellerException, IOException;
    GlobalUserDto followSeller(int userId, int sellerId) throws NotFoundException, IOException, UserIsNotSellerException, AlreadyFollowException;
    FollowersCountDto getTotalFollowers (int userId) throws NotFoundException, IOException, UserIsNotSellerException;
    FollowersDto getFollowersList(int userId, String orderBy) throws NotFoundException, IOException, UserIsNotSellerException;
    FollowedDto getFollowedList (int userId, String orderBy) throws NotFoundException, IOException;
    GlobalUserDto unfollowSeller(int userId, int sellerId) throws UserIsNotSellerException, NotFoundException, IOException, AlreadyFollowException;
    void addPostIdToSellerUser(PostDto postDto) throws NotFoundException, IOException, UserIsNotSellerException;
}
