package com.example.test.controller.Error;


import com.example.Commen.MsgUtil.ResponseHelper;
import com.example.test.pojo.MsgVehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.mail.AuthenticationFailedException;
import java.util.List;

@ControllerAdvice
public class SellerExceptionHandler {

   Logger logger = LoggerFactory.getLogger(SellerExceptionHandler.class);

    @Resource
    MsgVehicle msgVehicle;
    /**
     * @return
     */
    //@ResponseBody
    @ExceptionHandler(value = {SellerAuthorizeException.class})
    public String handlerSellerAuthorizeException(RedirectAttributes ra,SellerAuthorizeException e){
        ModelAndView andView = new ModelAndView();
        //msgVehicle.setFail(CodeMsg.AUTH_Fail.getMsg());
        ra.addFlashAttribute(msgVehicle);
        logger.warn(">"+e);
        //com.example.test.controller.Error.SellerAuthorizeException: 会话过期+
        return "redirect:/role/login";
    }

    @ExceptionHandler(value = RequestLimitException.class)
    public String ReqLimit(RequestLimitException e){
        logger.warn(String.valueOf(e));
        return "redirect:/main/";
    }

    /**
     * BindException
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResponseEntity bingException(BindException e){
        Boolean bindUncontain = (e == null || e.getBindingResult() ==null);
        if (!bindUncontain){
            List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
            System.out.println(allErrors);
        } else {

        }
        return ResponseHelper.failed(e.getMessage());

    }

    /**
     * 参数校验
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity exceptionHandler(MethodArgumentNotValidException e){
        Boolean fieldErrorUnobtainable = (e == null || e.getBindingResult() == null
                || CollectionUtils.isEmpty(e.getBindingResult().getAllErrors()) || e.getBindingResult().getAllErrors().get(0) == null);
        if (fieldErrorUnobtainable) {
            return ResponseHelper.successful();
        }

        StringBuilder sb = new StringBuilder();
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        if(!CollectionUtils.isEmpty(allErrors)){
            for (Object fieldError_temp:allErrors) {
                FieldError fieldError = (FieldError) fieldError_temp;
                String objectName = fieldError.getObjectName();
                String field = fieldError.getField();
                String defaultMessage = fieldError.getDefaultMessage();
                sb.append(objectName).append(".").append(field).append(":").append(defaultMessage).append(";");
            }
        }
        // 3.return
        logger.error("ArgumentFail》》:{}",sb.toString());
        return ResponseHelper.failed(sb.toString());
    }

    @ExceptionHandler(value = NoSuchMethodException.class)
    @ResponseBody
    public ResponseEntity exceptionHandler(NoSuchMethodException e){

        logger.error("NoSuchMethodException",e);

        return ResponseHelper.failed(e.toString());
    }

    @ExceptionHandler(value = AuthenticationFailedException.class)
    public ResponseEntity AuthenHandler(AuthenticationFailedException e){

        logger.error("NoSuchMethodException",e);

        return ResponseHelper.failed(e.toString());
    }


}