package br.com.meli.bootcamp.socialmeli.model.repository;

import br.com.meli.bootcamp.socialmeli.exception.UserNotFoundException;
import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;

import java.io.IOException;

public interface GlobalUserRepository {

    GlobalUserDto findGlobalUserById(int userId) throws UserNotFoundException, IOException;
    GlobalUserDto followSellerUser(int userId, GlobalUserDto sellerUser) throws Exception;
    GlobalUserDto unfollowSellerUser(int userId, GlobalUserDto sellerUser) throws Exception;

}
