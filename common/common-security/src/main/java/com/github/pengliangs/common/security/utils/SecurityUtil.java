package com.github.pengliangs.common.security.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pengliang on 2018-08-27 15:27
 */
public class SecurityUtil {

    /**
     * 是否是ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request) {
        String ajaxFlag = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(ajaxFlag);
    }
}
