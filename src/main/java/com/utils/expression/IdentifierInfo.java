package com.utils.expression;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 标识信息
 *
 */
@Data
@ToString
public class IdentifierInfo implements Serializable {
    static final long serialVersionUID = 42L;

    private static final Stack<Map<Integer, IdentifierInfo>> STACK = new Stack<>();
    private static final Map<Integer, IdentifierInfo> HEAP = new HashMap<>();

    /**
     * 全局  栈底
     * int a;
     *
     * function test() {
     *     int a;
     *     a = 1;
     *     this.a = a;
     * }
     *
     * test();
     *
     *
     *
     */

    /**
     * 名
     */
    private String raw;

    /**
     * 值
     */
    private Object value;

    /**
     * 类型
     */
    private IdentifierType type;

    enum IdentifierType {
        /**
         * 变量
         */
        VARIABLE,
        /**
         * 方法
         */
        FUNCTION
    }

}
