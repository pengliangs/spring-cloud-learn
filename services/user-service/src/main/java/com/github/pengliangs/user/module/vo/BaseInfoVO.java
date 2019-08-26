package com.github.pengliangs.user.module.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author pengliang
 * @date 2019/8/26 16:37
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BaseInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键;用户Id
     */
    @JsonSerialize(using = ToStringSerializer.class)
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

}
