package com.example.Commen.MsgUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;

public class ResponseHelper extends ResponseEntity {
    static Logger log = LoggerFactory.getLogger(ResponseHelper.class);
    public ResponseHelper(HttpStatus status) {
        super(status);
    }

    public static ResponseEntity failed(String message) {
        log.warn("messageResponseHelper>>"+message);
        ResponseEntity.created(URI.create("/login/error"));
        return (ResponseEntity) ResponseEntity.status(600);
    }

    public static ResponseEntity successful() {
        return ResponseEntity.ok("succ");
    }
}
