package br.com.meli.bootcamp.socialmeli.model.repository;

import br.com.meli.bootcamp.socialmeli.exception.AlreadyFollowException;
import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;
import br.com.meli.bootcamp.socialmeli.model.dto.NewUser;

import java.io.IOException;
import java.util.List;


public interface GlobalUserRepository {

    GlobalUserDto createNewUser(NewUser newUser) throws IOException;
    List<GlobalUserDto> findAllUsers() throws IOException;
    void deleteUser(int userId) throws NotFoundException, IOException;
    GlobalUserDto findGlobalUserById(int userId) throws NotFoundException, IOException;
    GlobalUserDto followSellerUser(int userId, GlobalUserDto sellerUser) throws IOException, NotFoundException, AlreadyFollowException;
    GlobalUserDto unfollowSellerUser(int userId, GlobalUserDto sellerUser) throws IOException, NotFoundException, AlreadyFollowException;
    void addPostIdToSellerUser(int postId, GlobalUserDto sellerUser) throws IOException;

}
