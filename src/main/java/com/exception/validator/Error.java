package com.exception.validator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Error {
    public enum CodeEnum {
        BAD_REQUEST("bad_request"),

        UNAUTHORIZED("unauthorized"),

        FORBIDDEN("forbidden"),

        NOT_FOUND("not_found"),

        UNEXPECTED_ERROR("unexpected_error");

        private final String value;

        CodeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static CodeEnum fromValue(String value) {
            for (CodeEnum b : CodeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    private List<String> messages;
    private int errorCode;
    /*private CodeEnum code;
    private Object data;*/

}
