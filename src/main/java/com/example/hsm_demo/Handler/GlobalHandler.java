package com.example.hsm_demo.Handler;

import com.example.hsm_demo.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalHandler {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {

    }

    @ExceptionHandler(Exception.class)
    public Response<?> handleException(Exception e) {
        log.error("request process error", e);
        return Response.failResponse(e.getMessage());
    }
}
