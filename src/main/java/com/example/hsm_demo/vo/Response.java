package com.example.hsm_demo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Response<T> {
    private T entity;
    private int code;
    private String message;

    public Response(T en){
        this.entity = en;
        this.code = 200;
        this.message = "niyouQbima?";
    }
    public Response(){

    }

}
