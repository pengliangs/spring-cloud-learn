package com.github.pengliangs.common.core.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author pengliang
 * @date 2019/8/27 18:10
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ApiException extends RuntimeException  {

    /**
     * 错误状态码
     */
    Integer errorCode;

    /**
     * 错误消息
     */
    String errorMsg;

}
