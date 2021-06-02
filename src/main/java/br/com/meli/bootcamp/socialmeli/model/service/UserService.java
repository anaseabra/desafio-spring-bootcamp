package br.com.meli.bootcamp.socialmeli.model.service;

import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;

import java.io.IOException;


public interface UserService {

    GlobalUserDto findById(int userId) throws IOException;
    GlobalUserDto followSeller(int userId, int sellerId) throws IOException;
}
