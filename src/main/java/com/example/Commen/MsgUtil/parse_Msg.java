package com.example.Commen.MsgUtil;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@ControllerAdvice

public class parse_Msg {
    Logger logger = LoggerFactory.getLogger(parse_Msg.class);

    @ResponseBody
    public static String parse_Msg(BindingResult result){
        if (result.hasErrors()){
            FieldError fieldError = result.getFieldError();
            System.out.printf("<<<getDefaultMessage>>>"+fieldError.getDefaultMessage());
            System.out.printf("hasmore");
            Object target = result.getTarget();
            System.out.printf(target.toString());
        }
        return "";
    }




}
