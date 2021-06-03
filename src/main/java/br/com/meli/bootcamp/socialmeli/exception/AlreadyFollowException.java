package br.com.meli.bootcamp.socialmeli.exception;

public class AlreadyFollowException extends Exception{

    public AlreadyFollowException() {
    }

    public AlreadyFollowException(String message) {
        super(message);
    }
}
