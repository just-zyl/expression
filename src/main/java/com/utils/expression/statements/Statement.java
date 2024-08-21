package com.utils.expression.statements;

import com.utils.expression.exceptions.ExpressionException;
import com.utils.expression.function.VarFunction;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * abs
 *
 */
@Data
@ToString
public abstract class Statement implements Serializable {
    static final long serialVersionUID = 42L;

    /**
     * 优先级
     */
    private int order = 0;

    /**
     * 开始位置
     */
    private int startPosition;

    /**
     * 结束位置
     */
    private int endPosition;

    /**
     * 执行
     *
     * @param variableValueGetFun 变量值获取器
     * @return 结果
     * @throws ExpressionException 异常
     */
    public abstract Object exec(VarFunction<String, Object> variableValueGetFun) throws ExpressionException;

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }
}
