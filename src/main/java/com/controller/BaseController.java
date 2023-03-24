package com.controller;

import com.exception.validator.Error;
import com.exception.validator.ErrorException;
import com.exception.validator.ValidateException;
import com.locale.Translator;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*import static com.util.DataUtils.camelToSnake;

public class BaseController {
    public String getUserName() {
        return ThreadContext.get(TrackingContextEnum.USER_INFO.getThreadKey());
    }

    public PageRequest pageRequest(List<String> sort, Integer size, Integer page) {
        if (CollectionUtils.isEmpty(sort)) {
            return PageRequest.of(page, size);
        }
        return PageRequest.of(page, size, sort(sort));
    }

    @SuppressWarnings("java:S3776")
    public Sort sort(List<String> sort) {
        if (CollectionUtils.isEmpty(sort)) {
            return null;
        }

        List<Sort.Order> orderList = new ArrayList<>();
        if (sort.get(0).contains(",")) {
            //&sort=code,asc&sort=lastUpdateDate,desc
            String[] tmpArr;
            for (String tmp : sort) {
                tmpArr = tmp.split(",");
                if (tmpArr.length > 1) {
                    if ("asc".equalsIgnoreCase(tmpArr[1])) {
                        orderList.add(Sort.Order.asc(camelToSnake(tmpArr[0])));
                    } else {
                        orderList.add(Sort.Order.desc(camelToSnake(tmpArr[0])));
                    }
                } else {
                    orderList.add(Sort.Order.asc(camelToSnake(tmpArr[0])));
                }
            }
        } else {
            //sort=code,asc
            for (String s : sort) {
                orderList.add(Sort.Order.asc(camelToSnake(s)));
            }
        }
        return Sort.by(orderList);
    }

    public List<String> getSortParam(String sort) {
        if (DataUtils.isNullOrEmpty(sort)) {
            return new ArrayList<>();
        }
        return Arrays.asList(sort.split(";"));
    }

    protected <T> ResponseResult<T> success(T data) {
        return ResponseResult.ofSuccess(data);
    }

}*/
@RestControllerAdvice
@Slf4j
public class BaseController implements ErrorController {

    @ExceptionHandler({ErrorException.class})
    public ResponseEntity<Error> handleErrorException(ErrorException exception) {
        /*log.warn("Caught a error exception request {}", exception.getError().getCode());
        log.debug("Caught a error exception request", exception);*/
        return new ResponseEntity<>(
                exception.getError(),
                exception.getStatus()
        );
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Error> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.error("Caught a unhandled request", exception);
        String message = "Invalid request";
        try {
            message = Translator.toMessage(exception.getBindingResult()
                    .getAllErrors().get(0).getDefaultMessage());
        } catch (Exception ignore) {
        }
        return new ResponseEntity<>(
                Error.builder()
                        .errorCode(HttpStatus.BAD_REQUEST.value())
                        .messages(Collections.singletonList(message))
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Error> handleException(Exception exception) {
        log.error("Caught a unhandled request", exception);
        return new ResponseEntity<>(
                Error.builder()
                        .errorCode(HttpStatus.BAD_REQUEST.value())
                        .messages(Collections.singletonList("Unexpected error"))
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler({ValidateException.class})
    public ResponseEntity<Error> handleValidateException(ValidateException exception) {
        log.error("Caught a unhandled request", exception);
        return new ResponseEntity<>(
                Error.builder()
                        .errorCode(HttpStatus.BAD_REQUEST.value())
                        .messages(Collections.singletonList(exception.getMessage()))
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<Error> handleAccessDeniedException(AccessDeniedException exception) {
        log.error("Caught a unhandled request", exception);
        return new ResponseEntity<>(
                Error.builder()
                        .errorCode(HttpStatus.FORBIDDEN.value())
                        .messages(Arrays.asList("Access is denied"))
                        .build(),
                HttpStatus.FORBIDDEN
        );
    }

   /* @Override
    public String getErrorPath() {
        return null;
    }*/

    @InitBinder
    public void initialBinderForTrimmingSpaces(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimEditor);
    }


    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Error> handleExpiredJwtException(ExpiredJwtException e) {
        log.error("Caught a unhandled request", e);
        return new ResponseEntity<>(
                Error.builder()
                        .errorCode(HttpStatus.BAD_REQUEST.value())
                        .messages(Arrays.asList("Token hết hạn"))
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Error> processRuntimeException(RuntimeException e) {
        log.error("Caught a unhandled request", e);
        return new ResponseEntity<>(
                Error.builder()
                        .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .messages(Arrays.asList("Có lỗi xảy ra, vui lòng liên hệ quản trị hệ thống"))
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }


    @ExceptionHandler(InsufficientAuthenticationException.class)
    public ResponseEntity<Error> processInsufficientAuthenticationException(InsufficientAuthenticationException e) {
        log.error("Caught a unhandled request", e);
        return new ResponseEntity<>(
                Error.builder()
                        .errorCode(HttpStatus.BAD_REQUEST.value())
                        .messages(Arrays.asList("Token hết hạn hoặc không hợp lệ"))
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }
}
