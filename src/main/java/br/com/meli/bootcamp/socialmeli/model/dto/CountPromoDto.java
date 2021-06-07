package br.com.meli.bootcamp.socialmeli.model.dto;

public class CountPromoDto {

    private int userId;
    private String userName;
    private int promoProductsCount;

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

    public int getPromoProductsCount() {
        return promoProductsCount;
    }

    public void setPromoProductsCount(int promoProductsCount) {
        this.promoProductsCount = promoProductsCount;
    }
}
