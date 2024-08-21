package com.utils.expression.expressions.values;

import com.utils.expression.enums.TokenTypeEnum;
import com.utils.expression.exceptions.ExpressionException;
import com.utils.expression.function.VarFunction;
import com.utils.expression.expressions.Expression;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;

/**
 * 布尔表达式
 *
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class ValueExpression extends Expression {

    /**
     * 节点类型
     */
    private TokenTypeEnum type;

    /**
     * 处理后有类型的值
     */
    private Object value;

    /**
     * 原始值
     */
    private String raw;

    public ValueExpression(TokenTypeEnum type, Object value, String raw) {
        this.type = type;
        this.value = value;
        this.raw = raw;
    }

    @Override
    public Object exec(VarFunction<String, Object> variableValueGetFun) throws ExpressionException {
        return getHandleValue(variableValueGetFun);
    }

    public boolean isEmpty() {
        return value == null || "".equals(value) || Objects.equals(value, 0.0D) || Objects.equals(value, 0.0F) || Objects.equals(value, 0);
    }

    public Object getHandleValue(VarFunction<String, Object> variableValueGetFun) throws ExpressionException {
        if (type == TokenTypeEnum.VARIABLE) {
            if (variableValueGetFun == null) {
                throw new ExpressionException("执行失败，未设置变量值获取器。");
            }
            String valueStr = String.valueOf(this.value);
            if (!variableValueGetFun.contains(valueStr)) {
                throw new ExpressionException("执行失败，未找到名为\"" + valueStr + "\"的变量。");
            }
            return variableValueGetFun.get(valueStr);
        }
        return value;
    }
}
