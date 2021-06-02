package br.com.meli.bootcamp.socialmeli.exception;

import java.util.Date;

public class ErrorInfo {

    private Date currentDate;
    private String message;

    public ErrorInfo(Date currentDate, String message) {
        this.currentDate = currentDate;
        this.message = message;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
