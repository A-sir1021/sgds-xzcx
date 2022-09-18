package com.example.test.controller.Error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "无权访问!")
public class SellerAuthorizeException extends RuntimeException{

    Logger log = LoggerFactory.getLogger(SellerAuthorizeException.class);
    private final String msg ;
    public SellerAuthorizeException(String msg) {
        super(msg);
        this.msg = msg;
    }

}