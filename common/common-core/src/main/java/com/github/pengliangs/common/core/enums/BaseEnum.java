package com.github.pengliangs.common.core.enums;

/**
 * 公共的基础枚举
 *
 * @author pengliang
 * @date 2019/8/26 16:44
 */
public enum BaseEnum {

    /**
     * 所有表中的是否有效字段
     */
    INVALID(0, "无效"),
    EFFECTIVE(1, "有效");

    BaseEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private int value;
    private String desc;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }}
