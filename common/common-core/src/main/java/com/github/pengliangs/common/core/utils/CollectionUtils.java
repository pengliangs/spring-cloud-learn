package com.github.pengliangs.common.core.utils;

import java.util.Collection;
import java.util.Map;

/**
 * 集合工具类
 * @author pengliang
 * @date 2019/4/21 20:01
 */
public interface CollectionUtils {

    /**
     * 集合是否为空
     * @param coll
     * @return
     */
    static boolean isEmpty(Collection<?> coll){
        return com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isEmpty(coll);
    }

    /**
     * 集合不为空
     * @param coll
     * @return
     */
    static boolean isNotEmpty(Collection<?> coll){
        return com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(coll);
    }

    /**
     * map是否为空
     * @param map
     * @return
     */
    static boolean isEmpty(Map<?, ?> map){
        return com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isEmpty(map);
    }

    /**
     * map不为空
     * @param map
     * @return
     */
    static boolean isNotEmpty(Map<?, ?> map){
        return com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(map);
    }
}
