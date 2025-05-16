package com.mycompany.property_management.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException manv){
        List<ErrorModel> errorModelList=new ArrayList<>();
        List<FieldError>fieldErrorList=manv.getBindingResult().getFieldErrors();
        ErrorModel errorModel=null;
        for(FieldError fe:fieldErrorList){
            logger.debug("Inside Field Validation: {} - {}", fe.getField(), fe.getDefaultMessage());
            logger.info("Inside Field Validation: {} - {}", fe.getField(), fe.getDefaultMessage());
            errorModel=new ErrorModel();
            errorModel.setCode(fe.getField());
            errorModel.setMessage(fe.getDefaultMessage());
            errorModelList.add(errorModel);
        }
        return new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex){
        for(ErrorModel em: bex.getErrors()){
            logger.debug("Business Exception is thrown level-as-debug : {} - {}", em.getCode(), em.getMessage());
            logger.info("Business Exception is thrown level-as-info: {} - {}", em.getCode(), em.getMessage());
            logger.warn("Business Exception is thrown level-as-warn: {} - {}", em.getCode(), em.getMessage());
            logger.error("Business Exception is thrown level-as-error: {} - {}", em.getCode(), em.getMessage());
        }

        return new ResponseEntity<List<ErrorModel>>(bex.getErrors(), HttpStatus.BAD_REQUEST);

    }
}
