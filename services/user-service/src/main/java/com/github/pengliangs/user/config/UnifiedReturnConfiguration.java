package com.github.pengliangs.user.config;

import com.github.pengliangs.common.core.exception.BusinessException;
import com.github.pengliangs.common.core.responce.ResultData;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常
 * @author pengliang
 * @date 2019/8/27 17:35
 */
@EnableWebMvc
@Configuration
public class UnifiedReturnConfiguration {


    @RestControllerAdvice("com.github.pengliangs.user.controller")
    static class CommonResultResponseAdvice implements ResponseBodyAdvice<Object> {
        @Override
        public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
            return true;
        }

        @Override
        public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType
                , Class<? extends HttpMessageConverter<?>> aClass
                , ServerHttpRequest serverHttpRequest
                , ServerHttpResponse serverHttpResponse) {

            if (body instanceof ResultData){
                return body;
            }

            return ResultData.success(body);
        }
    }

    @RestControllerAdvice("com.github.pengliangs.user.controller")
    static class UnifiedExceptionHandler{

        @ExceptionHandler(BusinessException.class)
        public ResultData<Void> handleBusinessException(BusinessException bex){
            return ResultData.failure(bex.getErrorCode(), bex.getErrorMsg());
        }

        @ExceptionHandler(Exception.class)
        public ResultData<Void> handleException(Exception ex){
            return ResultData.failure(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
