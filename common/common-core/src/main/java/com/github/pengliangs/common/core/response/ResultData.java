package com.github.pengliangs.common.core.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * 响应结果数据格式
 *
 * @author pengliang
 * @date 2019/8/27 17:11
 */
@Data
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
public final class ResultData<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 是否请求成功
	 */
	Boolean status = Boolean.TRUE;

	/**
	 * 错误状态码
	 */
	Integer errorCode = 0;

	/**
	 * 错误消息
	 */
	String errorMsg;

	/**
	 * 数据主体
	 */
	T body;

	public static <T> ResultData<T> success() {
		return new ResultData<T>()
			.setStatus(Boolean.TRUE);
	}

	public static <T> ResultData<T> success(T body) {
		return new ResultData<T>()
			.setStatus(Boolean.TRUE)
			.setBody(body);
	}

	public static <T> ResultData<T> success(T body, ResultStatus resultStatus) {
		return new ResultData<T>()
			.setStatus(Boolean.TRUE)
			.setBody(body)
			.setErrorCode(resultStatus.getCode())
			.setErrorMsg(resultStatus.getMessage());
	}

	public static <T> ResultData<T> failure() {
		return new ResultData<T>()
			.setStatus(Boolean.FALSE);
	}


	public static <T> ResultData<T> failure(Integer errorCode, String errorMsg) {
		return new ResultData<T>()
			.setStatus(Boolean.FALSE)
			.setErrorCode(errorCode)
			.setErrorMsg(errorMsg);
	}

	public static <T> ResultData<T> failure(ResultStatus resultStatus) {
		return new ResultData<T>()
			.setStatus(Boolean.FALSE)
			.setErrorCode(resultStatus.getCode())
			.setErrorMsg(resultStatus.getMessage());
	}

}
