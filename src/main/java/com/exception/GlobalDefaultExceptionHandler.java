package com.exception;

import com.exception.validator.ValidateException;
import com.locale.Translator;
import com.model.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@Slf4j
@RestControllerAdvice
public class GlobalDefaultExceptionHandler {

    /*@Value("${spring.servlet.multipart.max-file-size}")
    private String maxFileSize;*/

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ResponseResult<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.error("Caught a method argument not valid exception ", exception);
        String message = "Invalid request";
        try {
            message = Translator.toMessage(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        } catch (Exception ignore) {
            log.error(ignore.getMessage(), ignore);
        }
        return ResponseEntity.badRequest().body(ResponseResult.ofFail(message));
    }

    @ExceptionHandler({ValidateException.class})
    public ResponseEntity<ResponseResult<String>> handleValidateException(ValidateException exception) {
        log.error("Caught an invalid request ", exception);
        return ResponseEntity.badRequest().body(ResponseResult.ofFail(exception.getMessage()));
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class,
            MethodArgumentTypeMismatchException.class,
            BindException.class,
            IllegalArgumentException.class})
    public ResponseResult<String> handleHttpMessageNotReadableException(Exception e) {
        return ResponseResult.ofFail(Translator.toMessage("common.error.input.dataType"), e.getMessage());
    }

    @ExceptionHandler(value = AuthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseResult<String> handleAuthorizedException(Exception e) {
        return ResponseResult.ofFail(Translator.toMessage("common.unauthorized"));
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult<String> defaultExceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseResult.ofFail(Translator.toMessage("common.server.internal"));
    }

//    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public ResponseResult<String> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
//        log.error(e.getMessage(), e);
//        return ResponseResult.ofFail(Translator.toMessage("common.file.maximum.capacity", maxFileSize));
//    }

}
