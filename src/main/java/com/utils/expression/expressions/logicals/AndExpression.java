package com.utils.expression.expressions.logicals;

import com.utils.expression.constants.ExpressionConstant;
import com.utils.expression.exceptions.ExpressionException;
import com.utils.expression.function.VarFunction;
import com.utils.expression.statements.Statement;

/**
 * 并且
 *
 */
public class AndExpression extends LogicalExpression {

    public AndExpression() {
        super(ExpressionConstant.AND);
    }

    @Override
    public Object exec(VarFunction<String, Object> variableValueGetFun) throws ExpressionException {
        Statement left = super.getLeft();
        Statement right = super.getRight();
        Object leftValue = left.exec(variableValueGetFun);
        boolean leftValueTrue = (leftValue instanceof Boolean && ((Boolean) leftValue));
        if (!leftValueTrue && !(right instanceof OrExpression)) {
            // 1.当左树的结果为false，右子树的操作符不为||时无需遍历右子树直接返回。
            return leftValue;
        }
        Object rightValue = right.exec(variableValueGetFun);
        return leftValueTrue && ((boolean) rightValue);
    }
}
