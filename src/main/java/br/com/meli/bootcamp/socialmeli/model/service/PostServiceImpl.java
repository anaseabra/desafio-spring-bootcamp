package br.com.meli.bootcamp.socialmeli.model.service;

import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.exception.PromoPostException;
import br.com.meli.bootcamp.socialmeli.exception.UserIsNotSellerException;
import br.com.meli.bootcamp.socialmeli.model.dto.*;
import br.com.meli.bootcamp.socialmeli.model.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final GlobalUserService globalUserService;

    public PostServiceImpl(final PostRepository postRepository, final GlobalUserService globalUserService) {
        this.postRepository = postRepository;
        this.globalUserService = globalUserService;
    }

    @Override
    public PostDto createNewPost(PostDto postDto) throws IOException, NotFoundException, UserIsNotSellerException, PromoPostException {
        if(postDto.isHasPromo()){
            throw new PromoPostException("This is a promotional Post");
        }
        PostDto newPost = postRepository.createNewPost(postDto);
        globalUserService.addPostIdToSellerUser(postDto);
        return newPost;
    }

    @Override
    public FollowedPostsDto getFollowedPosts(int userId, String orderBy) throws Exception {
        FollowedPostsDto followedPostsDto = new FollowedPostsDto();
        GlobalUserDto user = globalUserService.getGlobalUserById(userId);

        FollowedDto followers = globalUserService.getFollowedList(userId, "");

        List<PostDto> posts = new ArrayList<>();

        for(UserDetail seller: followers.getFollowers()){
            GlobalUserDto sellerFollowed = globalUserService.getSellerUserById(seller.getUserId());
            for(int i: sellerFollowed.getMyPosts()){
                PostDto post = postRepository.getPostById(i);
                if(compareDates(post.getDate())){
                    posts.add(post);
                }

            }
        }

        followedPostsDto.setUserId(userId);
        followedPostsDto.setPosts(orderBy(posts, orderBy));

        return followedPostsDto;
    }

    @Override
    public PostDto createNewPromoPost(PostDto promoPost) throws PromoPostException, IOException, NotFoundException, UserIsNotSellerException {
        if(!promoPost.isHasPromo()){
            throw new PromoPostException("This is not a promotional Post");
        }
        PostDto newPost = postRepository.createNewPost(promoPost);
        globalUserService.addPostIdToSellerUser(promoPost);
        return newPost;
    }

    @Override
    public PromoPostCountDto getTotalPromoPosts(int userId) throws Exception {
        PromoPostCountDto promoPostCountDto = new PromoPostCountDto();

        promoPostCountDto.setUserId(userId);
        promoPostCountDto.setUserName(globalUserService.getSellerUserById(userId).getUserName());

        promoPostCountDto.setPromoProductsCount(postRepository.getPromoPosts(userId).size());

        return promoPostCountDto;
    }

    @Override
    public PromoPostListDto getPromoPosts(int userId) throws Exception {
        PromoPostListDto promoPostListDto = new PromoPostListDto();
        promoPostListDto.setUserId(userId);
        promoPostListDto.setUserName(globalUserService.getSellerUserById(userId).getUserName());

        promoPostListDto.setPromoPosts(postRepository.getPromoPosts(userId));

        return promoPostListDto;
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

    public List<PostDto> orderBy(List<PostDto> posts, String condition) {

        if (condition == null || condition.equals("date_desc")) {
            posts.sort(Comparator.comparing(PostDto::getDate).reversed());
        } else if (condition.equals("date_asc")) {
            posts.sort(Comparator.comparing(PostDto::getDate));
        }

        return posts;
    }
}
