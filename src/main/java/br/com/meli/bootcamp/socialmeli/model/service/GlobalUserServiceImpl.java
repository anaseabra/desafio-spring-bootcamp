package br.com.meli.bootcamp.socialmeli.model.service;


import br.com.meli.bootcamp.socialmeli.exception.UserIsNotSellerException;
import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.model.dto.*;
import br.com.meli.bootcamp.socialmeli.model.repository.GlobalUserRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GlobalUserServiceImpl implements GlobalUserService {

    private final GlobalUserRepository globalUserRepository;

    public GlobalUserServiceImpl(final GlobalUserRepository globalUserRepository) {
        this.globalUserRepository = globalUserRepository;
    }

    @Override
    public GlobalUserDto getGlobalUserById(int userId) throws Exception {
        return globalUserRepository.findGlobalUserById(userId);
    }

    @Override
    public GlobalUserDto getSellerUserById(int sellerId) throws NotFoundException, UserIsNotSellerException, IOException {
        GlobalUserDto sellerUser =  globalUserRepository.findGlobalUserById(sellerId);
        if(sellerUser != null && !sellerUser.isSeller()){
            throw new UserIsNotSellerException("User is not a seller");
        }

        return sellerUser;

    }

    @Override
    public GlobalUserDto followSeller(int userId, int sellerId) throws Exception {
        GlobalUserDto sellerUser = getSellerUserById(sellerId);

        if(!sellerUser.isSeller()){
            throw new UserIsNotSellerException("You can only follow seller user");
        }

        GlobalUserDto result = globalUserRepository.followSellerUser(userId, sellerUser);
        return result;
    }

    @Override
    public FollowersDto getFollowers(int userId) throws NotFoundException, IOException, UserIsNotSellerException {
        GlobalUserDto seller = getSellerUserById(userId);

        FollowersDto followersDto = new FollowersDto();
        followersDto.setUserId(seller.getUserId());
        followersDto.setUserName(seller.getUserName());
        followersDto.setFollowers(seller.getFollowers());

        return followersDto;
    }

    @Override
    public FollowersCountDto getTotalFollowers(int userId) throws NotFoundException, IOException, UserIsNotSellerException {
        FollowersCountDto followersCountDto= new FollowersCountDto();
        GlobalUserDto sellerUser = getSellerUserById(userId);

        followersCountDto.setUserId(sellerUser.getUserId());
        followersCountDto.setUserName(sellerUser.getUserName());
        followersCountDto.setFollowersCount(sellerUser.getFollowers().size());

        return followersCountDto;
    }

    @Override
    public FollowedDto getFollowedList(int userId) throws NotFoundException, IOException {
        GlobalUserDto user = globalUserRepository.findGlobalUserById(userId);

        FollowedDto followedDto = new FollowedDto();
        followedDto.setUserId(user.getUserId());
        followedDto.setUserName(user.getUserName());
        followedDto.setFollowedList(user.getFollowed());

        return followedDto;
    }

    @Override
    public GlobalUserDto unfollowSeller(int userId, int sellerId) throws Exception {
        GlobalUserDto sellerUser = getSellerUserById(sellerId);

        if(!sellerUser.isSeller()){
            throw new UserIsNotSellerException("You can only follow seller user");
        }
        GlobalUserDto result = globalUserRepository.unfollowSellerUser(userId, sellerUser);
        return result;
    }

    @Override
    public void addPostIdToSellerUser(PostDto postDto) throws NotFoundException, IOException, UserIsNotSellerException {
        globalUserRepository.addPostIdToSellerUser(postDto.getPostId(), getSellerUserById(postDto.getUserId()));
    }
}
