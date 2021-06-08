package br.com.meli.bootcamp.socialmeli.exception;

import org.apache.catalina.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class ExceptionControllerHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    ErrorInfo
    handleNotFoundExcpetion(NotFoundException e){
        return new ErrorInfo(new Date(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserIsNotSellerException.class)
    @ResponseBody
    ErrorInfo
    handleUserIsNotSellerExcpetion(UserIsNotSellerException e){
        return new ErrorInfo(new Date(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AlreadyFollowException.class)
    @ResponseBody
    ErrorInfo
    handleAlreadyFollowExcpetion(AlreadyFollowException e){
        return new ErrorInfo(new Date(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PromoPostException.class)
    @ResponseBody
    ErrorInfo
    handlePromoPostExcpetion(PromoPostException e){
        return new ErrorInfo(new Date(), e.getMessage());
    }

}
