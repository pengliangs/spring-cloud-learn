package com.github.pengliangs.common.core.exception;

/**
 * @author pengliang
 * @date 2019/8/30 15:10
 */
public class ConvertException extends RuntimeException {

    public ConvertException() {
    }

    public ConvertException(String message) {
        super(message);
    }

    public ConvertException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConvertException(Throwable cause) {
        super(cause);
    }
}
