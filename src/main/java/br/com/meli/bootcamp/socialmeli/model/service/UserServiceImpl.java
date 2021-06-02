package br.com.meli.bootcamp.socialmeli.model.service;


import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;
import br.com.meli.bootcamp.socialmeli.model.dto.UserDetail;
import br.com.meli.bootcamp.socialmeli.model.repository.GlobalUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final GlobalUserRepository globalUserRepository;

    public UserServiceImpl(final GlobalUserRepository globalUserRepository) {
        this.globalUserRepository = globalUserRepository;
    }

    @Override
    public GlobalUserDto findById(int userId) throws Exception {
        return globalUserRepository.findGlobalUserById(userId);
    }

    @Override
    public GlobalUserDto followSeller(int userId, int sellerId) throws Exception {
        GlobalUserDto seller = globalUserRepository.findSellerUserById(sellerId);
        GlobalUserDto result = globalUserRepository.followSellerUser(userId, seller);
        return result;
    }

    @Override
    public List<UserDetail> getSellerFollowers(int sellerId) throws Exception {
        List<UserDetail> followers = globalUserRepository.findFollowers(sellerId);
        return followers;
    }

}
