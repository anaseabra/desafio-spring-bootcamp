package br.com.meli.bootcamp.socialmeli.model.service;


import br.com.meli.bootcamp.socialmeli.model.repository.SellerRepository;
import br.com.meli.bootcamp.socialmeli.model.repository.UserRepository;
import br.com.meli.bootcamp.socialmeli.model.repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService{

    private final SellerRepository sellerRepository;
    private final UserRepository userRepository;

    public UserServiceImpl(final SellerRepository sellerRepository, UserRepository userRepository) {
        this.sellerRepository = sellerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void followSeller(int userId, int sellerId) {
        sellerRepository.findById(sellerId);

    }
}
