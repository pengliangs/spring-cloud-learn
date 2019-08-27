package com.github.pengliangs.common.core.responce;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
public final class ResultData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否请求成功
     */
    Boolean status = Boolean.TRUE;

    /**
     * 错误状态码
     */
    Integer errorCode;

    /**
     * 错误消息
     */
    String errorMsg;

    /**
     * 数据主体
     */
    T body;

    private ResultData(Boolean status, T body) {
        this.status = status;
        this.body = body;
    }

    private ResultData(Boolean status, Integer errorCode, String errorMsg) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static <T> ResultData<T> success(T body){
        return new ResultData<>(Boolean.TRUE,body);
    }

    public static <T> ResultData<T> failure(Integer errorCode, String errorMsg){
       return new ResultData<>(Boolean.FALSE,errorCode,errorMsg);
    }

}
