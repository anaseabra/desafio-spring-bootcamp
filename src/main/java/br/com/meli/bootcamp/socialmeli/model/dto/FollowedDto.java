package br.com.meli.bootcamp.socialmeli.model.dto;

import java.util.List;


public class FollowedDto {

    private int userId;
    private String userName;
    private List<UserDetail> followedList;

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
        return followedList;
    }

    public void setFollowedList(List<UserDetail> followedList) {
        this.followedList = followedList;
    }
}
