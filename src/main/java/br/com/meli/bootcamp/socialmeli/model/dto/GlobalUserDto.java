package br.com.meli.bootcamp.socialmeli.model.dto;

import java.util.List;
import java.util.Objects;

public class GlobalUserDto {
    private int userId;
    private String userName;
    private List<UserDetail> followed;
    private boolean seller;
    private List<Integer> myPosts;
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

    public boolean isSeller() {
        return seller;
    }

    public void setSeller(boolean seller) {
        this.seller = seller;
    }

    public List<Integer> getMyPosts() {
        return myPosts;
    }

    public void setMyPosts(List<Integer> myPosts) {
        this.myPosts = myPosts;
    }

    public List<UserDetail> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDetail> followers) {
        this.followers = followers;
    }

}
