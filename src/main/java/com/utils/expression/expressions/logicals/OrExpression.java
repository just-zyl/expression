package com.utils.expression.expressions.logicals;

import com.utils.expression.constants.ExpressionConstant;
import com.utils.expression.exceptions.ExpressionException;
import com.utils.expression.function.VarFunction;
import com.utils.expression.statements.Statement;

/**
 * 或者
 *
 */
public class OrExpression extends LogicalExpression {

    public OrExpression() {
        super(ExpressionConstant.OR);
    }

    @Override
    public Object exec(VarFunction<String, Object> variableValueGetFun) throws ExpressionException {
        Statement left = super.getLeft();
        Object leftValue = left.exec(variableValueGetFun);
        if ((boolean) leftValue) {
            // 1.当条件符为||时先校验左树是否满足，满足则直接返回无需遍历右子树。
            return leftValue;
        }
        Statement right = super.getRight();
        Object rightValue = right.exec(variableValueGetFun);
        return ((boolean) leftValue) || ((boolean) rightValue);
    }
}
