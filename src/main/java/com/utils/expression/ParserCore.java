package com.utils.expression;

import com.utils.expression.exceptions.ExpressionException;
import com.utils.expression.function.VarFunction;
import com.utils.expression.parser.TokenParser;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 解析器工具类
 *
 */
public class ParserCore {

    /**
     * 表达式解析器缓存
     */
    private static final Map<String, TokenParser> PARSER_CACHE = new ConcurrentHashMap<>();

    /**
     * 解析表达式
     *
     * @param expression 表达式
     * @param cache      是否使用缓存
     * @return 结果
     * @throws ExpressionException 异常
     */
    public static TokenParser parse(String expression, boolean cache) throws ExpressionException {
        TokenParser parser;
        if (!cache || (parser = PARSER_CACHE.get(expression)) == null) {
            parser = new TokenParser(expression);
            parser.parse();
            PARSER_CACHE.put(expression, parser);
        }
        return parser;
    }

    /**
     * 执行表达式
     *
     * @param expression          表达式
     * @param cache               是否使用缓存
     * @param variableValueGetFun 变量值获取方法
     * @return 结果
     * @throws ExpressionException 异常
     */
    public static Object exec(String expression, boolean cache, VarFunction<String, Object> variableValueGetFun) throws ExpressionException {
        TokenParser tokenParser = parse(expression, cache);
        Object execResult = tokenParser.exec(variableValueGetFun);
        return execResult;
    }
}
