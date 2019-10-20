package com.github.pengliangs.common.core.response;

/**
 * @author pengliang
 * @date 2019/8/30 15:18
 */
public interface ResultStatus {

    /**
     * 获取状态码
     * @return
     */
    Integer getCode();

    /**
     * 获取提示消息
     * @return
     */
    String getMessage();

}
