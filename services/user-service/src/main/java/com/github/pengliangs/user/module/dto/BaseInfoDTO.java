package com.github.pengliangs.user.module.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
	 * 用户性别:0 女，1 男
     */
    private Integer userSex;

    /**
     * 用户类型:0.真实用户 1.马甲用户
     */
    private Integer userType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
	 * 0.未删除 1.已删除
     */
    private Boolean delete;


}
