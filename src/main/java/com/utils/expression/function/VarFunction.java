package com.utils.expression.function;

import com.utils.expression.exceptions.ExpressionException;

/**
 * 获取方法
 *
 */
@FunctionalInterface
public interface VarFunction<K, V> {

    /**
     * 获取
     *
     * @param key 键
     * @return 获取值
     * @throws ExpressionException 表达式异常
     */
    V get(K key) throws ExpressionException;

    /**
     * 查找
     *
     * @param key 键
     * @return 是否存在键
     * @throws ExpressionException 表达式异常
     */
    default boolean contains(K key) throws ExpressionException {
        return get(key) != null;
    }
}
