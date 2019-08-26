package com.github.pengliangs.common.core.generate;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

/**
 * 数据库反向生成参数
 *
 * @author pengliang
 * @date 2019/8/26 15:06
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
@Data
public class GeneratorParam {

    /**
     * 用户名
     */
    String username;

    /**
     * 密码
     */
    String password;

    /**
     * 连接字符串
     */
    String url;

    /**
     * 作者名称
     */
    String authorName;

    /**
     * 表名称 多个逗号隔开
     */
    String tables;

    /**
     * 排除表前缀 多个逗号隔开
     */
    String prefixExcludes;
}
