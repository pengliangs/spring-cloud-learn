package com.github.pengliangs.user.module.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
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
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BaseInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键;用户Id
     */
    private Long id;

    /**
     * 用户头像
     */
    private String userPic;

    /**
     * 用户昵称
     */
    private String userNickName;

    /**
     * 用户性别:男-1;女-2
     */
    private Integer userSex;

    /**
     * 用户类型:真实用户-1;马甲用户-2;游客-3;kol用户-4
     */
    private Boolean userType;

    /**
     * 创建用户
     */
    private Long createUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改用户
     */
    private Long updateUser;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否有效:有效-1;无效-0
     */
    private Boolean valid;


}
