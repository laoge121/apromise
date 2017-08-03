package com.laoge.apromise.web.controller.interceptor;

import com.laoge.promise.common.resp.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yuhou on 2017/5/10.
 */
@ControllerAdvice(basePackages = "com.laoge.apromise.web.controller")
public class ErrorInterceptor extends ResponseEntityExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Response<?> handlerControllerException(HttpServletRequest request, Exception ex) {
        HttpStatus httpStatus = getStatus(request);
        return new Response(httpStatus.value(), null, ex.getLocalizedMessage());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        if (null == statusCode) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return HttpStatus.valueOf(statusCode);
    }


}
