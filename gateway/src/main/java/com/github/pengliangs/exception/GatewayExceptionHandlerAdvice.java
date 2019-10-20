package com.github.pengliangs.exception;

import org.springframework.cloud.gateway.support.NotFoundException;
import com.github.pengliangs.common.core.response.ResultData;
import com.github.pengliangs.enums.GatewayErrorEnum;
import io.netty.channel.ConnectTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author pengliang
 * @date 2019/10/20 16:22
 */
@Slf4j
@Component
public class GatewayExceptionHandlerAdvice {

	@ExceptionHandler(value = {ResponseStatusException.class})
	public ResultData handle(ResponseStatusException ex) {
		log.error("response status exception:{}", ex.getMessage());
		return ResultData.failure(GatewayErrorEnum.ERROR);
	}

	@ExceptionHandler(value = {ConnectTimeoutException.class})
	public ResultData handle(ConnectTimeoutException ex) {
		log.error("connect timeout exception:{}", ex.getMessage());
		return ResultData.failure(GatewayErrorEnum.CONNECT_TIME_OUT);
	}

	@ExceptionHandler(value = {NotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResultData handle(NotFoundException ex) {
		log.error("not found exception:{}", ex.getMessage());
		return ResultData.failure(GatewayErrorEnum.NOT_FOUND_SERVICE);
	}

	@ExceptionHandler(value = {RuntimeException.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResultData handle(RuntimeException ex) {
		log.error("runtime exception:{}", ex.getMessage());
		return ResultData.failure(GatewayErrorEnum.ERROR.getCode(),ex.getMessage());
	}

	@ExceptionHandler(value = {Exception.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResultData handle(Exception ex) {
		log.error("exception:{}", ex.getMessage());
		return ResultData.failure(GatewayErrorEnum.UNKNOWN.getCode(),ex.getMessage());
	}

	@ExceptionHandler(value = {Throwable.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResultData handle(Throwable throwable) {
		if (throwable instanceof ResponseStatusException) {
			return handle((ResponseStatusException) throwable);
		}
		if (throwable instanceof ConnectTimeoutException) {
			return handle((ConnectTimeoutException) throwable);
		}
		if (throwable instanceof NotFoundException) {
			return handle((NotFoundException) throwable);
		}
		if (throwable instanceof RuntimeException) {
			return handle((RuntimeException) throwable);
		}
		if (throwable instanceof Exception) {
			return handle((Exception) throwable);
		}
		return ResultData.failure(GatewayErrorEnum.UNKNOWN.getCode(),throwable.getMessage());
	}

}
