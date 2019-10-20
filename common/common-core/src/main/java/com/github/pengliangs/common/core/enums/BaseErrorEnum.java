package com.github.pengliangs.common.core.enums;

import com.github.pengliangs.common.core.response.ResultStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * @author pengliang
 * @date 2019/10/19 23:25
 */
public enum BaseErrorEnum implements ResultStatus {

	/**
	 * 400
	 */
	REQUEST_PARAMETER_ERROR(HttpServletResponse.SC_BAD_REQUEST, "请求参数错误或不完整"),
	/**
	 * 401
	 */
	UNAUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED, "请先进行认证"),
	/**
	 * 403
	 */
	FORBIDDEN(HttpServletResponse.SC_FORBIDDEN, "无权查看"),
	/**
	 * 404
	 */
	NOT_FOUND(HttpServletResponse.SC_NOT_FOUND, "未找到该路径"),
	/**
	 * 405
	 */
	METHOD_NOT_ALLOWED(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "请求方式不支持"),
	/**
	 * 406
	 */
	NOT_ACCEPTABLE(HttpServletResponse.SC_NOT_ACCEPTABLE, "不可接受该请求"),
	/**
	 * 411
	 */
	LENGTH_REQUIRED(HttpServletResponse.SC_LENGTH_REQUIRED, "长度受限制"),
	/**
	 * 415
	 */
	UNSUPPORTED_MEDIA_TYPE(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "不支持的媒体类型"),
	/**
	 * 416
	 */
	REQUESTED_RANGE_NOT_SATISFIABLE(HttpServletResponse.SC_REQUESTED_RANGE_NOT_SATISFIABLE, "不能满足请求的范围"),
	/**
	 * 500
	 */
	INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "服务器正在升级，请耐心等待"),
	/**
	 * 503
	 */
	SERVICE_UNAVAILABLE(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "请求超时"),

	SAVE_FAILURE(1000, "添加失败"),
	UPDATE_FAILURE(1001, "修改失败"),
	DELETE_FAILURE(1002, "删除失败"),
	RELEASE_FAILURE(1003, "发布失败"),
	UPLOAD_FAILURE(1004, "上传失败"),
	SEND_FAILURE(1005, "发送失败"),
	;

	BaseErrorEnum(Integer code, String message) {
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
