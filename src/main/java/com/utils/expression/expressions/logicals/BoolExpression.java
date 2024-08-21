package com.utils.expression.expressions.logicals;

import com.utils.expression.constants.ExpressionConstant;
import com.utils.expression.convert.DoubleConvert;
import com.utils.expression.exceptions.ExpressionException;
import com.utils.expression.ExpCore;
import com.utils.expression.convert.FloatConvert;
import com.utils.expression.function.VarFunction;
import com.utils.expression.statements.Statement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

/**
 * 布尔
 *
 */
public class BoolExpression extends LogicalExpression {

    public BoolExpression(String operator) {
        super(operator);
    }

    @Override
    public Object exec(VarFunction<String, Object> variableValueGetFun) throws ExpressionException {
        Statement left = super.getLeft();
        Statement right = super.getRight();
        Object leftValue = left.exec(variableValueGetFun);
        Object rightValue = right.exec(variableValueGetFun);
        String operator = super.getOperator();
        switch (operator) {
            case ExpressionConstant.EQ:
            case ExpressionConstant.EQ1:
                if (operator.equals(ExpressionConstant.EQ) || leftValue == null || rightValue == null || leftValue.getClass() == rightValue.getClass()) {
                    // 非强等与 或 两个类型相同直接比较。
                    return Objects.equals(leftValue, rightValue);
                }
                if (leftValue instanceof Double || rightValue instanceof Double) {
                    Double leftValueDouble = DoubleConvert.convert(leftValue);
                    Double rightValueDouble = DoubleConvert.convert(rightValue);
                    return Objects.equals(leftValueDouble, rightValueDouble);
                }
                if (leftValue instanceof Float || rightValue instanceof Float) {
                    Float leftValueFloat = FloatConvert.convert(leftValue);
                    Float rightValueFloat = FloatConvert.convert(rightValue);
                    return Objects.equals(leftValueFloat, rightValueFloat);
                }
                String leftValueStr = String.valueOf(leftValue), rightValueStr = String.valueOf(rightValue);
                return Objects.equals(leftValueStr, rightValueStr);
            case ExpressionConstant.NE:
                return !Objects.equals(leftValue, rightValue);
            case ExpressionConstant.GT:
                return this.compare(leftValue, rightValue) > 0;
            case ExpressionConstant.GE:
                return this.compare(leftValue, rightValue) >= 0;
            case ExpressionConstant.LT:
                return this.compare(leftValue, rightValue) < 0;
            case ExpressionConstant.LE:
                return this.compare(leftValue, rightValue) <= 0;
            default:
        }
        return null;
    }

    private int compare(Object leftValue, Object rightValue) throws ExpressionException {
        try {
            List<Method> methodList = ExpCore.CLASS_METHOD_CACHE.list(leftValue.getClass(), "compareTo", 2);
            for (Method method : methodList) {
                try {
                    Object invoke = method.invoke(leftValue, rightValue);
                    return ((int) invoke);
                } catch (InvocationTargetException | IllegalAccessException ignored) {
                }
            }
            throw new NoSuchMethodException();
        } catch (NoSuchMethodException e) {
            Double leftValueFloat = DoubleConvert.convert(leftValue);
            Double rightValueFloat = DoubleConvert.convert(rightValue);
            if (leftValueFloat == null || rightValueFloat == null) {
                throw new ExpressionException("比较参数不可为空");
            }
            if (Objects.equals(leftValueFloat, rightValueFloat)) {
                return 0;
            }
            if (leftValueFloat > rightValueFloat) {
                return 1;
            }
            return -1;
        }
    }
}
