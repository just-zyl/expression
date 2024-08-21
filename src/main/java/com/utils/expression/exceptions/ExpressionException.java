package com.utils.expression.exceptions;

/**
 * 表达式异常
 *
 */
public class ExpressionException extends Exception {

    public ExpressionException(String message) {
        super(message);
    }

    public ExpressionException(String message, Throwable cause) {
        super(message, cause);
    }
}
