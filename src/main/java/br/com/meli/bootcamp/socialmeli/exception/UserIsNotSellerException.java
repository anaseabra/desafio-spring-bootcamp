package br.com.meli.bootcamp.socialmeli.exception;

public class UserIsNotSellerException extends Exception {

    public UserIsNotSellerException() {
    }

    public UserIsNotSellerException(String message) {
        super(message);
    }
}
