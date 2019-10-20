package com.github.pengliangs.enums;

import com.github.pengliangs.common.core.response.ResultStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * @author pengliang
 * @date 2019/10/19 23:25
 */
public enum GatewayErrorEnum implements ResultStatus {

	ERROR(1000, "网关异常"),
	CONNECT_TIME_OUT(1001, "网关超时"),
	NOT_FOUND_SERVICE(1002, "服务未找到"),
	UNKNOWN(1004,"未知的")
	;

	GatewayErrorEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	private Integer code;

	private String message;

	@Override
	public Integer getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
