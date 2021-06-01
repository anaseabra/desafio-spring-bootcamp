package br.com.meli.bootcamp.socialmeli.model.dto;

import java.util.List;

public class UserDto {

    private int userId;
    private String username;
    List<SellerDto> followed;
    List<PostDto> followedPostDtos;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<SellerDto> getFollowed() {
        return followed;
    }

    public void setFollowed(List<SellerDto> followed) {
        this.followed = followed;
    }

    public List<PostDto> getFollowedPosts() {
        return followedPostDtos;
    }

    public void setFollowedPosts(List<PostDto> followedPostDtos) {
        this.followedPostDtos = followedPostDtos;
    }
}
