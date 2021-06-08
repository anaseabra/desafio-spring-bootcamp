package br.com.meli.bootcamp.socialmeli.model.dto;

import java.util.List;


public class FollowersDto {

    private int userId;
    private String userName;
    private List<UserDetail> followers;

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

    public List<UserDetail> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDetail> followers) {
        this.followers = followers;
    }
}
