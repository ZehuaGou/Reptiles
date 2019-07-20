package com.reptiles.pp.enums;

import lombok.Getter;

/**
 * @author Paul Lee
 * 一级分类枚举类
 */
@Getter
public enum OneCategoryEnum implements CodeEnum{

    /**
     * 代表时政分类
     */
    POLITICS(1, "时政"),

    /**
     * 代表财经分类
     */
    FINANCE(2, "财经"),

    /**
     * 代表军事分类
     */
    MILITARY(3, "军事"),

    /**
     * 代表教育分类
     */
    EDU(4, "教育"),

    /**
     * 代表其他分类
     */
    OTHER(5, "其他");

    /**
     * 主键
     */
    private Integer code;

    /**
     * 代表信息
     */
    private String message;

    OneCategoryEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
