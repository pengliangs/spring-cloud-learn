package com.github.pengliangs.common.core.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * LocalDateTime工具类
 *
 * @author pengliang
 * @date 2019/7/11 13:47
 */
public interface LocalDateTimeUtils {

    /**
     * 将date转换为LocalDateTime
     *
     * @param date
     * @return
     */
    static LocalDateTime convert(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 转换时间戳为LocalDateTime
     *
     * @param time
     * @return
     */
    static LocalDateTime convert(Long time) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
    }

    /**
     * 字符串转指定的LocalDateTime
     *
     * @param time
     * @param pattern
     * @return
     */
    static LocalDateTime convert(String time, String pattern) {
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * LocalDateTime 转Date
     *
     * @param time
     * @return
     */
    static Date toDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取毫秒
     *
     * @param localDateTime
     * @return
     */
    static long toEpochMilli(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 获取秒
     *
     * @param localDateTime
     * @return
     */
    static long toEpochSecond(LocalDateTime localDateTime) {
        return localDateTime.toEpochSecond(ZoneOffset.of("+8"));
    }

    /**
     * 格式化
     *
     * @param localDateTime
     * @param pattern
     * @return
     */
    static String format(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取当前时间的指定格式
     *
     * @param pattern
     * @return
     */
    static String formatNow(String pattern) {
        return format(LocalDateTime.now(), pattern);
    }

    /**
     * 日期加上一个数,根据field不同加不同值
     *
     * @param localDateTime
     * @param number
     * @param chronoUnit    ChronoUnit.*
     * @return
     */
    static LocalDateTime plus(LocalDateTime localDateTime, long number, TemporalUnit chronoUnit) {
        return localDateTime.plus(number, chronoUnit);
    }

    /**
     * 日期减去一个数,根据field不同减不同值
     *
     * @param time
     * @param number
     * @param chronoUnit ChronoUnit.*
     * @return
     */
    static LocalDateTime minus(LocalDateTime time, long number, TemporalUnit chronoUnit) {
        return time.minus(number, chronoUnit);
    }

    /**
     * 获取两个日期的差
     *
     * @param startTime
     * @param endTime
     * @param chronoUnit ChronoUnit.* 单位(年月日时分秒)
     * @return
     */
    static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit chronoUnit) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (chronoUnit == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (chronoUnit == ChronoUnit.MONTHS) {
            return period.getYears() * 12 + period.getMonths();
        }
        return chronoUnit.between(startTime, endTime);
    }

    /**
     * 获取一天的开始时间，2017,7,22 00:00
     *
     * @param localDateTime
     * @return
     */
    static LocalDateTime getDayStart(LocalDateTime localDateTime) {
        return localDateTime
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    /**
     * 获取一天的结束时间，2017,7,22 23:59:59.999999999
     *
     * @param localDateTime
     * @return
     */
    static LocalDateTime getDayEnd(LocalDateTime localDateTime) {
        return localDateTime
                .withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999999);
    }

    /**
     * 将指定的LocalDateTime时间重置为一天的开始时间
     *
     * @param localDateTime
     * @return
     */
    static LocalDateTime getDayTimeStart(LocalDateTime localDateTime) {
        return localDateTime
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    /**
     * 将指定的LocalDateTime时间重置为一天的开始时间,并将其转换指定的格式
     *
     * @param localDateTime
     * @param pattern
     * @return
     */
    static String formatDayTimeStart(LocalDateTime localDateTime, String pattern) {
        return format(getDayTimeStart(localDateTime), pattern);
    }

    /**
     * 将指定的LocalDateTime时间重置为一天的结束时间
     *
     * @param localDateTime
     * @return
     */
    static LocalDateTime getDayTimeEnd(LocalDateTime localDateTime) {
        return localDateTime
                .withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999999);
    }

    /**
     * 将指定的LocalDateTime时间重置为一天的结束时间,并将其转换指定的格式
     *
     * @param localDateTime
     * @param pattern
     * @return
     */
    static String formatDayTimeEnd(LocalDateTime localDateTime, String pattern) {
        return format(getDayTimeEnd(localDateTime), pattern);
    }
}
