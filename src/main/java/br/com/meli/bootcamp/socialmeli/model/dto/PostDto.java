package br.com.meli.bootcamp.socialmeli.model.dto;

import br.com.meli.bootcamp.socialmeli.Utils.ProductCategory;

import java.util.Date;

public class PostDto {

    private static int postId = 0;
    private int userId;
    private Date date;
    private ProductDto detail;
    private ProductCategory category;
    private double price;

    public PostDto(int postId) {
        postId++;
        this.date = new Date();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public ProductDto getDetail() {
        return detail;
    }

    public void setDetail(ProductDto detail) {
        this.detail = detail;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
