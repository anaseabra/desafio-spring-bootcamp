package br.com.meli.bootcamp.socialmeli.model.dto;

public class NewUser {

    private String userName;
    private boolean seller;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isSeller() {
        return seller;
    }

    public void setSeller(boolean seller) {
        this.seller = seller;
    }
}
