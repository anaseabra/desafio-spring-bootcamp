package br.com.meli.bootcamp.socialmeli.model.dto;

import java.util.List;

public class PromoPostListDto {

    private int userId;
    private String userName;
    private List<PostDto> promoPosts;

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

    public List<PostDto> getPromoPosts() {
        return promoPosts;
    }

    public void setPromoPosts(List<PostDto> promoPosts) {
        this.promoPosts = promoPosts;
    }
}
