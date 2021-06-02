package br.com.meli.bootcamp.socialmeli.model.repository;

import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;

import java.io.IOException;
import java.util.List;

public interface GlobalUserRepository {

    GlobalUserDto findGlobalUserById(int userId) throws IOException;
    GlobalUserDto findSellerUserById(int userId) throws IOException;
    List<GlobalUserDto> findFollowers(int userId) throws IOException;
    void followSellerUser(int userId, GlobalUserDto sellerUser) throws IOException;


}
