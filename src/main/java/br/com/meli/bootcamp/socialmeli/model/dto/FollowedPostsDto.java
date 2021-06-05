package br.com.meli.bootcamp.socialmeli.model.dto;

import java.util.List;

public class FollowedPostsDto {

    private int userId;
    private List<PostDto> posts;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<PostDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDto> posts) {
        this.posts = posts;
    }
}
