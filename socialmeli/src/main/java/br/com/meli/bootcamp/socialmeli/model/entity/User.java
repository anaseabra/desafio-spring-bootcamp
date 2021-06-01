package br.com.meli.bootcamp.socialmeli.model.entity;

import java.util.List;

public class User {

    private int userId;
    private String username;
    List<Seller> followed;
    List<Post> followedPosts;


}
