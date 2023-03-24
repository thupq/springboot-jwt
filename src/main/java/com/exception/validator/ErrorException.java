package com.exception.validator;

import com.locale.Translator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public class ErrorException extends RuntimeException {

    private Error error;
    private HttpStatus status;

    public static ErrorException notFound(String codeMessage) {
        return new ErrorException(
                Error.builder()
                        //.code(Error.CodeEnum.NOT_FOUND)
                        .errorCode(HttpStatus.BAD_REQUEST.value())
                        .messages(Arrays.asList(Translator.toMessage(codeMessage)))
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }
}
