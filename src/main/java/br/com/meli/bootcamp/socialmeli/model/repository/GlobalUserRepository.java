package br.com.meli.bootcamp.socialmeli.model.repository;

import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;
import br.com.meli.bootcamp.socialmeli.model.dto.UserDetail;

import java.io.IOException;
import java.util.List;

public interface GlobalUserRepository {

    GlobalUserDto findGlobalUserById(int userId) throws Exception;
    GlobalUserDto findSellerUserById(int userId) throws IOException, Exception;
    List<UserDetail> findFollowers(int userId) throws IOException, Exception;
    GlobalUserDto followSellerUser(int userId, GlobalUserDto sellerUser) throws Exception;


}
