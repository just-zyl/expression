package com.utils.expression.statements;

import com.utils.expression.exceptions.ExpressionException;
import com.utils.expression.function.VarFunction;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * if
 *
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class IfStatement extends Statement {

    /**
     * 布尔表达式
     */
    private Statement test;

    /**
     * 结果
     */
    private Statement consequent;

    /**
     * 其它
     */
    private Statement alternate;

    @Override
    public Object exec(VarFunction<String, Object> variableValueGetFun) throws ExpressionException {
        Object exec = test.exec(variableValueGetFun);
        if (((boolean) exec)) {
            return consequent.exec(variableValueGetFun);
        }
        return alternate.exec(variableValueGetFun);
    }
}
