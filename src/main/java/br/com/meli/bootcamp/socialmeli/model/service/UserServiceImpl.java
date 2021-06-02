package br.com.meli.bootcamp.socialmeli.model.service;


import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;
import br.com.meli.bootcamp.socialmeli.model.repository.GlobalUserRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService{

    private final GlobalUserRepository globalUserRepository;

    public UserServiceImpl(final GlobalUserRepository globalUserRepository) {
        this.globalUserRepository = globalUserRepository;
    }

    @Override
    public GlobalUserDto findById(int userId) throws IOException {
        return globalUserRepository.findGlobalUserById(userId);
    }

    @Override
    public GlobalUserDto followSeller(int userId, int sellerId) throws IOException {
        GlobalUserDto seller = globalUserRepository.findSellerUserById(sellerId);
        GlobalUserDto userUpdated = globalUserRepository.findGlobalUserById(userId);
        return userUpdated;

    }

}
