package br.com.meli.bootcamp.socialmeli.model.dto;

import java.util.List;

public class SellerDto {

    private int sellerId;
    private String username;
    private List<UserDto> followers;


    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserDto> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDto> followers) {
        this.followers = followers;
    }
}
