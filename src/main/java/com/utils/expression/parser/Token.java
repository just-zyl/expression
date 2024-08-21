package com.utils.expression.parser;

import com.utils.expression.enums.TokenTypeEnum;
import lombok.Data;
import lombok.ToString;

/**
 * 节点
 *
 */
@Data
@ToString
public class Token {

    /**
     * 节点类型
     */
    private TokenTypeEnum type;

    /**
     * 原始值
     */
    private String raw;

    /**
     * 是否存在小数点
     */
    private boolean point;

    /**
     * 开始位置
     */
    private int startPosition;

    /**
     * 结束位置
     */
    private int endPosition;

    public Token(TokenTypeEnum type, String raw) {
        this.type = type;
        this.raw = raw;
    }
}
