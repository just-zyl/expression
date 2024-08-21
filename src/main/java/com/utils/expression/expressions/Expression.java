package com.utils.expression.expressions;

import com.utils.expression.statements.Statement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 表达式
 *
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public abstract class Expression extends Statement {

    public String getFullPath() {
        return null;
    }
}
