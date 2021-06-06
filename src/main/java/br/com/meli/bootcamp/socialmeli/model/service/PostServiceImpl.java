package br.com.meli.bootcamp.socialmeli.model.service;

import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.exception.UserIsNotSellerException;
import br.com.meli.bootcamp.socialmeli.model.dto.*;
import br.com.meli.bootcamp.socialmeli.model.repository.GlobalUserRepository;
import br.com.meli.bootcamp.socialmeli.model.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final GlobalUserService globalUserService;

    public PostServiceImpl(final PostRepository postRepository, final GlobalUserService globalUserService) {
        this.postRepository = postRepository;
        this.globalUserService = globalUserService;
    }

    @Override
    public PostDto createNewPost(PostDto postDto) throws IOException, NotFoundException, UserIsNotSellerException {
        PostDto newPost = postRepository.createNewPost(postDto);
        globalUserService.addPostIdToSellerUser(postDto);
        return newPost;
    }

    @Override
    public FollowedPostsDto getFollowedPosts(int userId) throws Exception {
        FollowedPostsDto followedPostsDto = new FollowedPostsDto();
        GlobalUserDto user = globalUserService.getGlobalUserById(userId);

        FollowedDto followers = globalUserService.getFollowedList(userId, "");

        List<PostDto> posts = new ArrayList<>();

        for(UserDetail seller: followers.getFollowers()){
            GlobalUserDto sellerFollowed = globalUserService.getSellerUserById(seller.getUserId());
            for(Integer i: sellerFollowed.getMyPosts()){
                PostDto post = postRepository.getPostById(i);
                if(compareDates(post.getDate())){
                    posts.add(post);
                }

            }
        }

        posts.sort(Comparator.comparing(PostDto::getDate).reversed());

        List<PostDto> sortedPostList = posts.subList(0, Math.min(posts.size(), 20));

        followedPostsDto.setUserId(userId);
        followedPostsDto.setPosts(sortedPostList);

        return followedPostsDto;
    }

    boolean compareDates (Date date){
        long postDate =  date.getTime();
        long dateToCompare = new Date().getTime();
        double timeSpentInWeeks = (double) (dateToCompare - postDate) / 604800000;

        if(timeSpentInWeeks > 2){
            return false;
        }

        return true;
    }
}
