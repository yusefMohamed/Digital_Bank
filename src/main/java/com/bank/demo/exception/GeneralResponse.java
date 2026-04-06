package com.bank.demo.exception;
import lombok.*;

@Setter
@Getter
public class GeneralResponse<T> {

    private T data;
    private String message;
    private int status;


    public GeneralResponse(T data, String message, int status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }
}