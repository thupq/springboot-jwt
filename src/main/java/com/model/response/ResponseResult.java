package com.model.response;

import com.common.constant.Constants;
import com.util.DataUtils;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseResult<T> {

    private String errorCode;
    private String message;
    private T data;

    public static <T> ResponseResult<T> ofSuccess() {
        ResponseResult<T> ResponseResult = new ResponseResult<>();
        ResponseResult.setErrorCode(Constants.ERROR_CODE.SUCCESS);
        ResponseResult.setMessage("success");
        return ResponseResult;
    }

    public static <T> ResponseResult<T> ofSuccess(String message) {
        ResponseResult<T> ResponseResult = new ResponseResult<>();
        ResponseResult.setMessage(message);
        ResponseResult.setErrorCode(Constants.ERROR_CODE.SUCCESS);
        return ResponseResult;
    }

    public static <T> ResponseResult<T> ofSuccess(T data) {
        ResponseResult<T> ResponseResult = new ResponseResult<>();
        ResponseResult.setMessage("success");
        ResponseResult.setErrorCode(Constants.ERROR_CODE.SUCCESS);
        ResponseResult.setData(data);
        return ResponseResult;
    }

    public static <T> ResponseResult<T> ofSuccess(String message, T data) {
        ResponseResult<T> ResponseResult = new ResponseResult<>();
        ResponseResult.setMessage(message);
        ResponseResult.setData(data);
        ResponseResult.setErrorCode(Constants.ERROR_CODE.SUCCESS);
        return ResponseResult;
    }

    public ResponseResult() {
    }

    public ResponseResult(String errorCode) {
        this.errorCode = errorCode;
    }

    public ResponseResult(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ResponseResult(String errorCode, String message, T data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> ofFail(String message) {
        ResponseResult<T> ResponseResult = new ResponseResult<>();
        ResponseResult.setMessage(message);
        ResponseResult.setErrorCode(Constants.ERROR_CODE.INVALID);
        return ResponseResult;
    }

    public static <T> ResponseResult<T> ofFail(String message, T data) {
        ResponseResult<T> ResponseResult = new ResponseResult<>();
        ResponseResult.setMessage(message);
        ResponseResult.setErrorCode(Constants.ERROR_CODE.INVALID);
        ResponseResult.setData(data);
        return ResponseResult;
    }

    public static <T> ResponseResult<T> ofFail(T data) {
        ResponseResult<T> ResponseResult = new ResponseResult<>();
        ResponseResult.setData(data);
        ResponseResult.setErrorCode(Constants.ERROR_CODE.INVALID);
        return ResponseResult;
    }

    public static <T> ResponseResult<T> ofFail() {
        ResponseResult<T> ResponseResult = new ResponseResult<>();
        ResponseResult.setErrorCode(Constants.ERROR_CODE.INVALID);
        return ResponseResult;
    }

    public boolean isSuccess() {
        return DataUtils.safeEqual(Constants.ERROR_CODE.SUCCESS, this.errorCode);
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
