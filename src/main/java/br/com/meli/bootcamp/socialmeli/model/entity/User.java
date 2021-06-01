package br.com.meli.bootcamp.socialmeli.model.entity;

import java.util.List;

public class User {

    private int userId;
    private String username;
    List<Seller> followed;
    List<Post> followedPosts;

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

    public List<Seller> getFollowed() {
        return followed;
    }

    public void setFollowed(List<Seller> followed) {
        this.followed = followed;
    }

    public List<Post> getFollowedPosts() {
        return followedPosts;
    }

    public void setFollowedPosts(List<Post> followedPosts) {
        this.followedPosts = followedPosts;
    }
}
