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
    @TableField("user_pic")
    private String userPic;

    /**
     * 用户昵称
     */
    @TableField("user_nick_name")
    private String userNickName;

    /**
     * 用户性别:男-1;女-2
     */
    @TableField("user_sex")
    private Integer userSex;

    /**
     * 用户类型:真实用户-1;马甲用户-2;游客-3;kol用户-4
     */
    @TableField("user_type")
    private Boolean userType;

    /**
     * 创建用户
     */
    @TableField("create_user")
    private Long createUser;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 修改用户
     */
    @TableField("update_user")
    private Long updateUser;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 是否有效:有效-1;无效-0
     */
    @TableLogic
    @TableField("is_valid")
    private Boolean valid;


}
