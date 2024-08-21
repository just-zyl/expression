package com.utils.expression.expressions.logicals;

import com.utils.expression.constants.ExpressionConstant;
import com.utils.expression.exceptions.ExpressionException;
import com.utils.expression.function.VarFunction;
import com.utils.expression.statements.Statement;

import java.util.Collection;
import java.util.Map;

/**
 * 是
 *
 */
public class IsExpression extends LogicalExpression {

    public IsExpression(String operator) {
        super(operator);
    }

    @Override
    public Object exec(VarFunction<String, Object> variableValueGetFun) throws ExpressionException {
        Statement left = super.getLeft();
        Object leftValue = left.exec(variableValueGetFun);
        String operator = super.getOperator();
        switch (operator) {
            case ExpressionConstant.IS_EMPTY:
                return leftValue == null || "".equals(leftValue) ||
                        (leftValue instanceof Collection && ((Collection<?>) leftValue).isEmpty()) ||
                        (leftValue instanceof Map && ((Map<?, ?>) leftValue).isEmpty());
            case ExpressionConstant.IS_NOT_EMPTY:
                return leftValue != null && !"".equals(leftValue) &&
                        !(leftValue instanceof Collection && ((Collection<?>) leftValue).isEmpty()) &&
                        !(leftValue instanceof Map && ((Map<?, ?>) leftValue).isEmpty());
            case ExpressionConstant.IS_NULL:
                return leftValue == null;
            case ExpressionConstant.IS_NOT_NULL:
                return leftValue != null;
            default:
        }
        return null;
    }
}
