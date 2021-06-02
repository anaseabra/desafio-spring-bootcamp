package br.com.meli.bootcamp.socialmeli.model.service;

import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;
import br.com.meli.bootcamp.socialmeli.model.dto.UserDetail;

import java.util.List;


public interface UserService {

    GlobalUserDto findById(int userId) throws Exception;
    GlobalUserDto followSeller(int userId, int sellerId) throws Exception;
    List<UserDetail> getSellerFollowers (int sellerId) throws Exception;

}
