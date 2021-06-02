package br.com.meli.bootcamp.socialmeli.model.dto;

import org.apache.catalina.User;

import java.util.List;
import java.util.Objects;

public class GlobalUserDto {
    private int userId;
    private String userName;
    private List<UserDetail> followed;
    private List<PostDto> followedPosts;
    private boolean seller;
    private List<PostDto> myPosts;
    private List<UserDetail> followers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GlobalUserDto that = (GlobalUserDto) o;
        return userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserDetail> getFollowed() {
        return followed;
    }

    public void setFollowed(List<UserDetail> followed) {
        this.followed = followed;
    }

    public List<PostDto> getFollowedPosts() {
        return followedPosts;
    }

    public void setFollowedPosts(List<PostDto> followedPosts) {
        this.followedPosts = followedPosts;
    }

    public boolean isSeller() {
        return seller;
    }

    public void setSeller(boolean seller) {
        this.seller = seller;
    }

    public List<PostDto> getMyPosts() {
        return myPosts;
    }

    public void setMyPosts(List<PostDto> myPosts) {
        this.myPosts = myPosts;
    }

    public List<UserDetail> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDetail> followers) {
        this.followers = followers;
    }

}
