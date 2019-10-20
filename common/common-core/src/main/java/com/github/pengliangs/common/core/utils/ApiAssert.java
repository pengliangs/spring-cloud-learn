package com.github.pengliangs.common.core.utils;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.github.pengliangs.common.core.exception.ApiException;
import com.github.pengliangs.common.core.response.ResultStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * API断言
 *
 * @author pengliang
 * @date 2019/7/11 14:40
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiAssert {

    public static void equals(ResultStatus resultStatus, Object obj1, Object obj2) {
        if (!Objects.equals(obj1, obj2)) {
            failure(resultStatus);
        }
    }

    public static void isTrue(ResultStatus resultStatus, boolean condition) {
        if (!condition) {
            failure(resultStatus);
        }
    }

    public static void isFalse(ResultStatus resultStatus, boolean condition) {
        if (condition) {
            failure(resultStatus);
        }
    }

    public static void isNull(ResultStatus resultStatus, Object... conditions) {
        if (ObjectUtils.isNotNull(conditions)) {
            failure(resultStatus);
        }
    }

    public static void notNull(ResultStatus resultStatus, Object... conditions) {
        if (ObjectUtils.isNull(conditions)) {
            failure(resultStatus);
        }
    }

    public static void failure(ResultStatus resultStatus) {
        throw new ApiException(resultStatus.getCode(), resultStatus.getMessage());
    }


    public static void notEmpty(ResultStatus resultStatus, Object[] array) {
        if (ObjectUtils.isEmpty(array)) {
            failure(resultStatus);
        }
    }

    public static void noNullElements(ResultStatus resultStatus, Object[] array) {
        if (array != null) {
            for (Object element : array) {
                if (element == null) {
                    failure(resultStatus);
                }
            }
        }
    }


    public static void notEmpty(ResultStatus resultStatus, Collection<?> collection) {
        if (CollectionUtils.isEmpty(collection)) {
            failure(resultStatus);
        }
    }

    public static void notEmpty(ResultStatus resultStatus, Map<?, ?> map) {
        if (CollectionUtils.isEmpty(map)) {
            failure(resultStatus);
        }
    }

    public static void isEmpty(ResultStatus resultStatus, Collection<?> collection) {
        if (CollectionUtils.isNotEmpty(collection)) {
            failure(resultStatus);
        }
    }

    public static void isEmpty(ResultStatus resultStatus, Map<?, ?> map) {
        if (CollectionUtils.isNotEmpty(map)) {
            failure(resultStatus);
        }
    }

}
