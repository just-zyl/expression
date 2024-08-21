package com.utils.expression.enums;

/**
 * token类型
 *
 */
public enum TokenTypeEnum {
    /**
     * 关键字
     */
    KEYWORD,
    /**
     * 变量
     */
    VARIABLE,
    /**
     * 标识符
     */
    IDENTIFIER,
    /**
     * 数字
     */
    NUMBER,
    /**
     * 字符串
     */
    STRING,
    /**
     * 标点符号
     */
    PUNCTUATOR,
    /**
     * (过时)符号
     */
    CONDITION,
    /**
     * (过时)列表
     */
    ARRAY
}
