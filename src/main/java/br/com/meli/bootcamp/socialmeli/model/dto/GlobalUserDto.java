package br.com.meli.bootcamp.socialmeli.model.dto;

import java.util.List;
import java.util.Objects;

public class GlobalUserDto {
    private int userId;
    private int userName;
    private List<GlobalUserDto> followed;
    List<PostDto> followedPostDtos;
    private boolean isSeller;
    private List<PostDto> myPostDtos;

    private List<GlobalUserDto> followers;
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

    public int getUserName() {
        return userName;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }

    public List<GlobalUserDto> getFollowed() {
        return followed;
    }

    public List<PostDto> getFollowedPosts() {
        return followedPostDtos;
    }

    public boolean isSeller() {
        return isSeller;
    }

    public void setSeller(boolean seller) {
        isSeller = seller;
    }

    public List<PostDto> getMyPosts() {
        return myPostDtos;
    }

    public List<GlobalUserDto> getFollowers() {
        return followers;
    }
    
}
