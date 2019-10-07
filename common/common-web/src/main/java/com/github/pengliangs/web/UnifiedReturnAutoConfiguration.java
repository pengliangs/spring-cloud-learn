package com.github.pengliangs.web;

import com.github.pengliangs.web.exception.ApiException;
import com.github.pengliangs.web.response.ResultData;
import com.github.pengliangs.web.utils.JacksonUtils;
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
 * 统一异常 及 返回
 *
 * @author pengliang
 * @date 2019/8/27 17:35
 */
@EnableWebMvc
@Configuration
public class UnifiedReturnAutoConfiguration {

    @RestControllerAdvice({
            "com.github.pengliangs.user.controller"
    })
    static class ResultDataResponseAdvice implements ResponseBodyAdvice<Object> {
        @Override
        public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
            return true;
        }

        @Override
        public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType
                , Class<? extends HttpMessageConverter<?>> aClass
                , ServerHttpRequest serverHttpRequest
                , ServerHttpResponse serverHttpResponse) {

            if (body instanceof ResultData) {
                return body;
            }

			ResultData resultData = ResultData.success(body);
            if (body instanceof String){
            	return JacksonUtils.toJson(resultData);
			}

            return resultData;
        }
    }

    @RestControllerAdvice({
            "com.github.pengliangs.user.controller"
    })
    static class UnifiedExceptionHandler {

        @ExceptionHandler(ApiException.class)
        public ResultData<Void> handleApiException(ApiException apiEx) {
            return ResultData.failure(apiEx.getErrorCode(), apiEx.getErrorMsg());
        }

        @ExceptionHandler(Exception.class)
        public ResultData<Void> handleException(Exception ex) {
			ex.printStackTrace();
            return ResultData.failure(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
