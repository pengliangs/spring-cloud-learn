package com.github.pengliangs.user.module.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户基础信息表
 * </p>
 *
 * @author pengliang
 * @since 2019-08-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_base_info")
public class BaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键;用户Id
     */
    @TableId("id")
    private Long id;

    /**
     * 用户头像
     */
    @TableField("user_avatar")
    private String userAvatar;

    /**
     * 用户昵称
     */
    @TableField("user_nickname")
    private String userNickname;

    /**
     * 用户性别:0 女，1 男
     */
    @TableField("user_sex")
    private Integer userSex;

    /**
     * 用户类型:0.真实用户 1.马甲用户
     */
    @TableField("user_type")
    private Integer userType;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 0.未删除 1.已删除
     */
    @TableLogic
    @TableField("is_delete")
    private Boolean delete;


}
