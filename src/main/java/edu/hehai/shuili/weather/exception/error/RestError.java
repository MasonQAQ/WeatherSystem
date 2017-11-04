package edu.hehai.shuili.weather.exception.error;

import java.util.List;

public class RestError {
    private int code;
    private List<RestFieldError> message;

    public RestError() {
    }

    public RestError(int code, List <RestFieldError> message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List <RestFieldError> getMessage() {
        return message;
    }

    public void setMessage(List <RestFieldError> message) {
        this.message = message;
    }
}