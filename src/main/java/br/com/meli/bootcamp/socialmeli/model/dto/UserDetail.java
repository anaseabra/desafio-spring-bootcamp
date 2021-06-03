package br.com.meli.bootcamp.socialmeli.model.dto;

import java.util.Objects;

public class UserDetail {

    private int userId;
    private String userName;
//    private boolean seller;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetail that = (UserDetail) o;
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

//    public boolean isSeller() {
//        return seller;
//    }
//
//    public void setSeller(boolean seller) {
//        this.seller = seller;
//    }

}
