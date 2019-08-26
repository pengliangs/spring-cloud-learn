package com.github.pengliangs.common.core.utils;


import com.github.pengliangs.common.core.constant.StringConstant;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 字符串工具类
 *
 * @author pengliang
 * @date 2019/4/14 11:02
 */
public interface StringUtils {


    /**
     * 匹配字符出现次数
     *
     * @param str
     * @param sub
     * @return
     */
    static int countMatches(final CharSequence str, final CharSequence sub) {
        return org.apache.commons.lang3.StringUtils.countMatches(str, sub);
    }

    /**
     * 去除左右空格
     *
     * @param str
     * @return
     */
    static String trim(final String str) {
        return org.apache.commons.lang3.StringUtils.trim(str);
    }

    /**
     * <p>在字符串后面添加时间戳</p>
     *
     * @param str
     * @return 返回结果 str-timeMillis
     */
    static String concatAfterCurrentTimeMillis(final String str) {
        return str.concat("-").concat(String.valueOf(System.currentTimeMillis()));
    }

    /**
     * <p>
     * 判断字符串是否为空
     * </p>
     *
     * @param cs 需要判断字符串
     * @return 判断结果
     */
    static boolean isEmpty(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isEmpty(cs);
    }

    /**
     * <p>如果oldStr为空 返回newStr</p>
     *
     * @param sourceStr  原字符
     * @param replaceStr 替代字符
     * @return
     */
    static String isEmpty(final String sourceStr, final String replaceStr) {
        return isEmpty(sourceStr) ? replaceStr : sourceStr;
    }

    /**
     * <p>
     * 判断字符串是否不为空
     * </p>
     *
     * @param cs 需要判断字符串
     * @return 判断结果
     */
    static boolean isNotEmpty(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isNotEmpty(cs);
    }

    /**
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     *
     * @param cs
     * @return
     */
    static boolean isBlank(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isBlank(cs);
    }

    /**
     * StringUtils.isNotBlank(null)      = false
     * StringUtils.isNotBlank("")        = false
     * StringUtils.isNotBlank(" ")       = false
     * StringUtils.isNotBlank("bob")     = true
     * StringUtils.isNotBlank("  bob  ") = true
     *
     * @param cs
     * @return
     */
    static boolean isNotBlank(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isNotBlank(cs);
    }

    /**
     * 如果为空原资费为空使用替换字符代替
     *
     * @param resourceStr
     * @param repStr
     * @return
     */
    static String isNotBlank(final String resourceStr, final String repStr) {
        return isNotBlank(resourceStr) ? resourceStr : repStr;
    }

    /**
     * 如果是个一个isNotBlank的字符则返回 ""
     *
     * @param str
     * @return
     */
    static String getNotBlankReturnBlank(final String str) {
        return isNotBlank(str) ? StringConstant.BLANK : str;
    }

    /**
     * 拆分字符
     *
     * @param str
     * @param separatorChars
     * @return
     */
    static String[] split(final String str, final String separatorChars) {
        return org.apache.commons.lang3.StringUtils.split(str, separatorChars);
    }

    /**
     * 删除匹配字符,返回新字符
     *
     * @param sourceStr
     * @param repStr
     * @param separator
     * @return
     */
    static String delMatch(final String sourceStr, final String repStr, final String separator) {
        if (isBlank(sourceStr)) {
            return sourceStr;
        }
        String[] symbol = split(sourceStr, separator);
        if (Objects.isNull(symbol)) {
            return sourceStr;
        }
        return join(Arrays
                .stream(symbol)
                .filter(str -> !Objects.equals(repStr, str))
                .collect(Collectors.toList()), separator);
    }

    /**
     * 去除指定分隔符下的重复字符
     *
     * @param str    字符
     * @param symbol 分隔符
     * @return
     */
    static String distinctStr(String str, String symbol) {
        if (StringUtils.isNotBlank(str)) {
            return StringUtils.join(Arrays.stream(str.split(symbol)).collect(Collectors.toSet()), symbol);
        }
        return StringConstant.BLANK;
    }

    /**
     * 将集合连接为一个字符串,以指定的符号隔开
     *
     * @param iterable
     * @param separator
     * @return
     */
    static String join(final Iterable<?> iterable, final String separator) {
        return org.apache.commons.lang3.StringUtils.join(iterable, separator);
    }
}
