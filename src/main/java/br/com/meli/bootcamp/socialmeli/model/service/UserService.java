package br.com.meli.bootcamp.socialmeli.model.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void followSeller(int userId, int sellerId);
}
