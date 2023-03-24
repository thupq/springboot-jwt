package com.exception.validator;

import com.locale.Translator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorException extends RuntimeException {

    private java.lang.Error error;
    private HttpStatus status;

    public static ErrorException notFound(String codeMessage) {
        return new ErrorException(
                Error.builder()
                        //.code(Error.CodeEnum.NOT_FOUND)
                        .errorCode(HttpStatus.BAD_REQUEST.value())
                        .messages(List.of(Translator.toMessage(codeMessage)))
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }
}
