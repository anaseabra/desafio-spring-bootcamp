package br.com.meli.bootcamp.socialmeli.model.repository;

import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;

import java.io.IOException;

public interface GlobalUserRepository {

    GlobalUserDto findGlobalUserById(int userId) throws NotFoundException, IOException;
    GlobalUserDto followSellerUser(int userId, GlobalUserDto sellerUser) throws Exception;
    GlobalUserDto unfollowSellerUser(int userId, GlobalUserDto sellerUser) throws Exception;
    void addPostIdToSellerUser(int postId, GlobalUserDto sellerUser) throws IOException;

}
